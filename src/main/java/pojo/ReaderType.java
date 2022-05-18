package pojo;

public class ReaderType {
    private Integer        rdType;
    private String     rdTypeName;
    private Integer        CanLendQty;
    private Integer        CanLendDay;
    private Integer        CanContinueTimes;
    private double     PunishRate;
    private Integer        DateValid;

    public int getRdType() {
        return rdType;
    }

    public void setRdType(int rdType) {
        this.rdType = rdType;
    }

    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }

    public int getCanLendQty() {
        return CanLendQty;
    }

    public void setCanLendQty(int canLendQty) {
        CanLendQty = canLendQty;
    }

    public int getCanLendDay() {
        return CanLendDay;
    }

    public void setCanLendDay(int canLendDay) {
        CanLendDay = canLendDay;
    }

    public int getCanContinueTimes() {
        return CanContinueTimes;
    }

    public void setCanContinueTimes(int canContinueTimes) {
        CanContinueTimes = canContinueTimes;
    }

    public double getPunishRate() {
        return PunishRate;
    }

    public void setPunishRate(double punishRate) {
        PunishRate = punishRate;
    }

    public int getDateValid() {
        return DateValid;
    }

    public void setDateValid(int dateValid) {
        DateValid = dateValid;
    }

    @Override
    public String toString() {
        return "ReaderType{" +
                "rdType=" + rdType +
                ", rdTypeName='" + rdTypeName + '\'' +
                ", CanLendQty=" + CanLendQty +
                ", CanLendDay=" + CanLendDay +
                ", CanContinueTimes=" + CanContinueTimes +
                ", PunishRate=" + PunishRate +
                ", DateValid=" + DateValid +
                '}';
    }
}
