package bhtu.work.tths.models;

public class PrizeType {
    /**
     * Phan thuong: keo(cai), banh(goi)
     */
    private String nameOfPrize;
    private int unitPrice;

    public String getNameOfPrize() {
        return nameOfPrize;
    }

    public void setNameOfPrize(String nameOfPrize) {
        this.nameOfPrize = nameOfPrize;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

}