package pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Borrow {
    private Integer BorrowID          ;
    private Integer rdID              ;
    private String rdName             ;
    private Integer bkID              ;
    private String bkName             ;
    private Integer IdContinueTimes   ;
    @JSONField(format = "yyyy-MM-dd")
    private Date IdDateOut         ;
    @JSONField(format = "yyyy-MM-dd")
    private Date IdDateRetPlan     ;
    @JSONField(format = "yyyy-MM-dd")
    private Date IdDateRetAct      ;
    private Integer IdOverDay         ;
    private Double IdOverMoney       ;
    private Double IdPunishMoney     ;
    private Integer IsHasReturn       ;
    private String IsHasReturnStr     ;
    private String OperatorLend      ;
    private String OperatorRet       ;


    public Integer getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(Integer borrowID) {
        BorrowID = borrowID;
    }

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

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public Integer getIdContinueTimes() {
        return IdContinueTimes;
    }

    public void setIdContinueTimes(Integer idContinueTimes) {
        IdContinueTimes = idContinueTimes;
    }

    public Date getIdDateOut() {
        return IdDateOut;
    }

    public void setIdDateOut(Date idDateOut) {
        IdDateOut = idDateOut;
    }

    public Date getIdDateRetPlan() {
        return IdDateRetPlan;
    }

    public void setIdDateRetPlan(Date idDateRetPlan) {
        IdDateRetPlan = idDateRetPlan;
    }

    public Date getIdDateRetAct() {
        return IdDateRetAct;
    }

    public void setIdDateRetAct(Date idDateRetAct) {
        IdDateRetAct = idDateRetAct;
    }


    public Integer getIdOverDay() {
        return IdOverDay;
    }

    public void setIdOverDay(Integer idOverDay) {
        IdOverDay = idOverDay;
    }

    public Double getIdOverMoney() {
        return IdOverMoney;
    }

    public void setIdOverMoney(Double idOverMoney) {
        IdOverMoney = idOverMoney;
    }

    public Double getIdPunishMoney() {
        return IdPunishMoney;
    }

    public void setIdPunishMoney(Double idPunishMoney) {
        IdPunishMoney = idPunishMoney;
    }

    public Integer getIsHasReturn() {
        return IsHasReturn;
    }

    public void setIsHasReturn(Integer isHasReturn) {
        IsHasReturn = isHasReturn;
    }

    public String getOperatorLend() {
        return OperatorLend;
    }

    public void setOperatorLend(String operatorLend) {
        OperatorLend = operatorLend;
    }

    public String getOperatorRet() {
        return OperatorRet;
    }

    public void setOperatorRet(String operatorRet) {
        OperatorRet = operatorRet;
    }

    public String getIsHasReturnStr() {
        return IsHasReturnStr;
    }

    public void setIsHasReturnStr(String isHasReturnStr) {
        IsHasReturnStr = isHasReturnStr;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "BorrowID=" + BorrowID +
                ", rdID=" + rdID +
                ", rdName='" + rdName + '\'' +
                ", bkID=" + bkID +
                ", bkName='" + bkName + '\'' +
                ", IdContinueTimes=" + IdContinueTimes +
                ", IdDateOut=" + IdDateOut +
                ", IdDateRetPlan=" + IdDateRetPlan +
                ", IdDateRetAct=" + IdDateRetAct +
                ", IdOverDay=" + IdOverDay +
                ", IdOverMoney=" + IdOverMoney +
                ", IdPunishMoney=" + IdPunishMoney +
                ", IsHasReturn=" + IsHasReturn +
                ", OperatorLend='" + OperatorLend + '\'' +
                ", OperatorRet='" + OperatorRet + '\'' +
                '}';
    }
}
