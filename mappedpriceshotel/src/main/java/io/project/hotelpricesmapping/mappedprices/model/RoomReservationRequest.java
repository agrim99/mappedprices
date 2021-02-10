package io.project.hotelpricesmapping.mappedprices.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RoomReservationRequest {

    private Long hotel_id;

    private String date;

    private String room_category_id;

    private String occupancy;


    public RoomReservationRequest() {

    }

    public RoomReservationRequest(Long hotel_id, String date, String room_category_id) {
        this.hotel_id = hotel_id;
        this.date = date;
        this.room_category_id = room_category_id;
    }

    public RoomReservationRequest(Long hotel_id, String date, String room_category_id, String occupancy) {
        this.hotel_id = hotel_id;
        this.date = date;
        this.room_category_id = room_category_id;
        this.occupancy = occupancy;
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

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }


    public String getGetKeyForCache() {

        return hotel_id + "@" + date + "@" + room_category_id + "@" + occupancy;

    }
}
