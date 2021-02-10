package io.project.hotelpricesmapping.mappedprices.model;

public class RoomPrice {

    private Double price1;
    private Double price2;
    private Double price3;


    public RoomPrice() {

    }

    public RoomPrice(Double price1, Double price2, Double price3) {
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = price1;
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        this.price2 = price2;
    }

    public Double getPrice3() {
        return price3;
    }

    public void setPrice3(Double price3) {
        this.price3 = price3;
    }
}
