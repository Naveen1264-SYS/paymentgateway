package com.projectdev.qrcode_gen;

public class PaytmRequestBody {
    private String userName;
    private String mobileNo;
    private String accountType;
    private String accountNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public PaytmRequestBody(String userName, String mobileNo, String accountType, String accountNo) {
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.accountType = accountType;
        this.accountNo = accountNo;
    }
}
