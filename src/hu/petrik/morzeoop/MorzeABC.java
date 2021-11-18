package hu.petrik.morzeoop;

public class MorzeABC {

    private String betu;
    private String morzeJel;

    public MorzeABC(String betu, String morzeJel) {
        this.betu = betu;
        this.morzeJel = morzeJel;
    }

    public String getBetu() {
        return betu;
    }

    public void setBetu(String betu) {
        this.betu = betu;
    }

    public String getMorzeJel() {
        return morzeJel;
    }

    public void setMorzeJel(String morzeJel) {
        this.morzeJel = morzeJel;
    }


}
