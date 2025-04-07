package com.projectdev.qrcode_gen;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@SpringBootApplication
public class QrcodeGenerator {

	private String QRCODE_PATH = "D:\\Dbufer\\QR_Paytm";

	public String writeQRCode(PaytmRequestBody paytmRequestBody) throws WriterException, IOException {
		String qrcode =QRCODE_PATH+paytmRequestBody.getUserName()+"-QRCODE.png";

		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix= writer.encode(paytmRequestBody.getUserName()+"\n"+paytmRequestBody.getAccountNo()+"\n"+paytmRequestBody.getAccountType()+"\n"+paytmRequestBody.getMobileNo(), BarcodeFormat.QR_CODE,350,350);

		Path path = FileSystems.getDefault().getPath(qrcode);
		MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);


		return  "QRCODE is generated successfully";
	}
	public  String readQRCode (String qrcodeImage) throws IOException, NotFoundException {
		BufferedImage bufferedImage = ImageIO.read(new File(qrcodeImage));
		LuminanceSource  luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap  binaryBitmap =  new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result result= new MultiFormatReader().decode(binaryBitmap);
		return  result.getText();



	}

	public static void main(String[] args) throws IOException, WriterException, NotFoundException {
		QrcodeGenerator codeGenerator= new QrcodeGenerator();
		// Code to generate QR
//		System.out.println(
//				codeGenerator.writeQRCode(new PaytmRequestBody("Naveen","6303018890","Personal","Acc230")));

		System.out.println(codeGenerator.readQRCode("QRCODE_PATH"+"QR_PaytmNaveen-QRCODE.png"));
	}

}
