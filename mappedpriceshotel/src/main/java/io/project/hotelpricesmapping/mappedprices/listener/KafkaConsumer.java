package io.project.hotelpricesmapping.mappedprices.listener;

import io.project.hotelpricesmapping.mappedprices.controller.RoomReservationController;
import io.project.hotelpricesmapping.mappedprices.model.RoomReservationCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private RoomReservationController roomReservationController;

    @KafkaListener(topics = "Kafka_mapped", groupId = "group_json", containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(RoomReservationCsv roomReservationCsv){

        System.out.println("Consumed Message");
        roomReservationController.createRoomReservation(roomReservationCsv);

    }


}
