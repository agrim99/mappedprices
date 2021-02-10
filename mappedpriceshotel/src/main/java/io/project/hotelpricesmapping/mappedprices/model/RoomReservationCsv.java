package io.project.hotelpricesmapping.mappedprices.model;

import io.project.hotelpricesmapping.mappedprices.converter.StringMapConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.util.Map;

public class RoomReservationCsv {

    private Long hotel_id;

    private String date;

    private String room_category_id;

    private Double price1;

    private Double price2;

    private Double price3;

    public RoomReservationCsv() {

    }

    public RoomReservationCsv(Long hotel_id, String date, String room_category_id, Double price1, Double price2, Double price3) {
        this.hotel_id = hotel_id;
        this.date = date;
        this.room_category_id = room_category_id;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom_category_id() {
        return room_category_id;
    }

    public void setRoom_category_id(String room_category_id) {
        this.room_category_id = room_category_id;
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

    public String getGetKeyForCache() {
        return hotel_id + "@" + date + "@" + room_category_id + "@";

    }
}
