package io.project.hotelpricesmapping.mappedprices.controller;

import io.project.hotelpricesmapping.mappedprices.converter.StringMapConverter;
import io.project.hotelpricesmapping.mappedprices.model.*;
import io.project.hotelpricesmapping.mappedprices.repository.RoomReservationRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import com.google.gson.*;
//import org.json.simple.JSONObject;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoomReservationController {

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    public static final String HASH_KEY = "PRICE";

//    @Autowired
//    private StringMapConverter stringMapConverter;


    @PostMapping("room_reservations")
    public String createRoomReservation(@RequestBody RoomReservationCsv roomReservationCsv){

        //roomReservationRepository.saveprice(roomReservation);
        //return roomReservation.getOccupancy_to_price();


//        roomReservationRepository.saveprice(roomReservation.getHotel_id(), roomReservation.getDate(),
//                roomReservation.getOccupancy_to_price(), roomReservation.getRoom_category_id());
//        return "Saved Successfully";




//        String occupancy_to_price = "1: " + roomReservationCsv.getPrice1() + ", 2: " + roomReservationCsv.getPrice2() +
//                ", 3: " + roomReservationCsv.getPrice3();
//        //occupancy_to_price.append("1: " + roomReservationCsv.getPrice1());
//
//        Gson gson = new Gson();
//        String json_price = gson.toJson(occupancy_to_price);
//
//        String otp = "{ \"1\":\"roomReservationCsv.getPrice1()\",\" 2': " + roomReservationCsv.getPrice2() +
//                ", '3': " + roomReservationCsv.getPrice3() + "}";
//
//        roomReservationRepository.saveprice(roomReservationCsv.getHotel_id(), roomReservationCsv.getDate(),
//                otp, roomReservationCsv.getRoom_category_id());
//
//        return "Saved Successfully";




        //RoomPrice roomPrice = new RoomPrice(roomReservationCsv.getPrice1(), roomReservationCsv.getPrice2(),
          //      roomReservationCsv.getPrice3());

        Map<Integer, Double> map = new HashMap<>();
        map.put(1,roomReservationCsv.getPrice1());
        map.put(2,roomReservationCsv.getPrice2());
        map.put(3,roomReservationCsv.getPrice3());
        Gson gson = new Gson();
        String json_price = gson.toJson(map);

        System.out.println(json_price);
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setHotel_id(roomReservationCsv.getHotel_id());
        roomReservation.setDate(roomReservationCsv.getDate());
        roomReservation.setRoom_category_id(roomReservationCsv.getRoom_category_id());
        roomReservation.setOccupancy_to_price(json_price);
        System.out.println(roomReservation.getOccupancy_to_price());
        roomReservationRepository.save(roomReservation);
        //roomReservationRepository.save(roomReservationCsv.getHotel_id(), roomReservationCsv.getDate(),
        //        json_price, roomReservationCsv.getRoom_category_id());

        return "Saved Successfully";



//        JsonObject room_price = new JsonObject();
//        room_price.addProperty("1",roomReservationCsv.getPrice1());
//        room_price.addProperty("2",roomReservationCsv.getPrice2());
//        room_price.addProperty("3",roomReservationCsv.getPrice3());
        //roomReservationRepository.saveprice(roomReservationCsv.getHotel_id(), roomReservationCsv.getDate(),
        //        room_price, roomReservationCsv.getRoom_category_id());
        //room_price.put("1",roomReservationCsv.getPrice1());

//        JSONObject room_price = new JSONObject();
//        room_price.put("1",roomReservationCsv.getPrice1());
//        room_price.put("2",roomReservationCsv.getPrice2());
//        room_price.put("3",roomReservationCsv.getPrice3());
//////        roomReservationRepository.saveprice(roomReservationCsv.getHotel_id(), roomReservationCsv.getDate(),
//////                room_price, roomReservationCsv.getRoom_category_id());
////
////
////
//        RoomReservation roomReservation = new RoomReservation();
//        roomReservation.setHotel_id(roomReservationCsv.getHotel_id());
//        roomReservation.setDate(roomReservationCsv.getDate());
//        roomReservation.setRoom_category_id(roomReservationCsv.getRoom_category_id());
//        roomReservation.setOccupancy_to_price(room_price);
//        roomReservationRepository.save(roomReservation);
//
//        return "Saved Successfully";


    }


    @GetMapping("room_reservations")
    public Double getRoomReservationPrice(@RequestBody RoomReservationRequest roomReservationRequest){

        //System.out.println(10101010);

        List<String> priceslist = roomReservationRepository.getPrice(roomReservationRequest.getHotel_id(),
                roomReservationRequest.getDate(), roomReservationRequest.getRoom_category_id());

        //System.out.println(priceslist.size());


        if(priceslist.size() == 0){
            return -10.0;
        }


        String prices = priceslist.get(0);
        Gson gson = new Gson();
        Map<String, Double> map = new HashMap<String, Double>();
        //System.out.println(prices);
        map = (Map<String, Double>)gson.fromJson(prices, map.getClass());

        String occupancy = roomReservationRequest.getOccupancy();

//        Integer occ = 1;
//        if(occupancy.equals("2"))
//            occ=2;
//        else if(occupancy.equals("3"))
//            occ=3;

        if(map.containsKey(occupancy)){
            return map.get(occupancy);
        }

        return -1.0;


//        List<String> priceslist = roomReservationRepository.getPrice(roomReservationRequest.getHotel_id(),
//                roomReservationRequest.getDate(), roomReservationRequest.getRoom_category_id());
//
//        if(priceslist.size() == 0){
//            return -10.0;
//        }
//
//        String price = priceslist.get(0);
//        Map<String, Double> pricemap = stringMapConverter.convertToEntityAttribute(price);
//
//        String occupancy = roomReservationRequest.getOccupancy();
//
//        if(pricemap.containsKey(occupancy)){
//            return pricemap.get(occupancy);
//        }
//
//        return -1.0;



    }


    /*@PutMapping("room_reservations")
    public Map<String, Double> updateRoomReservation(@RequestBody RoomReservation roomReservation){

        roomReservationRepository.updatePrice(roomReservation.getHotel_id(),
                roomReservation.getDate(), roomReservation.getRoom_category_id(),
                roomReservation.getOccupancy_to_price());

        return roomReservation.getOccupancy_to_price();


    }


    @DeleteMapping("room_reservations")
    public String deleteRoomReservation(@RequestBody RoomReservationRequest roomReservationRequest){

        roomReservationRepository.deleterow(roomReservationRequest.getHotel_id(),
                roomReservationRequest.getDate(), roomReservationRequest.getRoom_category_id());

        return "Deleted Successfully";

    }*/






}
