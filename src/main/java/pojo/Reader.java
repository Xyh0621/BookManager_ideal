package pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Reader {
    private  Integer   rdID        ;
    private  String   rdName      ;

    private  Integer rdType       ;
    private String rdTypeStr      ;
    private String rdSexStr      ;
    private  String   rdSex       ;
    private  String   rdPhone     ;
    private  String   rdEmail     ;
    @JSONField(format = "yyyy-MM-dd")
    private  Date rdDateReg   ;
    private  Integer   rdBorrowQty ;
    private  Integer   rdStatus    ;
    private  String   rdPwd       ;

    public Integer getRdID() {
        return rdID;
    }

    public void setRdID(Integer rdID) {
        this.rdID = rdID;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdSex() {
        return rdSex;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
        if (rdSex.equals("m")){
            this.rdSexStr = "男";
        }else{
            this.rdSexStr = "女";
        }
    }

    public String getRdSexStr() {
        return rdSexStr;
    }


    public Integer getRdType() { return rdType; }

    public void setRdType(Integer rdType) { this.rdType = rdType; }

    public String getRdPhone() {
        return rdPhone;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public Date getRdDateReg() {
        return rdDateReg;
    }

    public void setRdDateReg(Date rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public Integer getRdBorrowQty() {
        return rdBorrowQty;
    }

    public void setRdBorrowQty(Integer rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public Integer getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(Integer rdStatus) {
        this.rdStatus = rdStatus;
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }

    public String getRdTypeStr() {
        return rdTypeStr;
    }

    public void setRdTypeStr(String rdTypeStr) {
        this.rdTypeStr = rdTypeStr;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rdID=" + rdID +
                ", rdName='" + rdName + '\'' +
                ", rdType=" + rdType +
                ", rdTypeStr='" + rdTypeStr + '\'' +
                ", rdSex='" + rdSex + '\'' +
                ", rdPhone='" + rdPhone + '\'' +
                ", rdEmail='" + rdEmail + '\'' +
                ", rdDateReg=" + rdDateReg +
                ", rdBorrowQty=" + rdBorrowQty +
                ", rdStatus=" + rdStatus +
                ", rdPwd='" + rdPwd + '\'' +
                '}';
    }
}
