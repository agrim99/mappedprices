package io.project.hotelpricesmapping.mappedprices.readcsv;

import io.project.hotelpricesmapping.mappedprices.model.RoomReservationCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReader {

    @Autowired
    private KafkaTemplate<String, RoomReservationCsv> kafkaTemplate;

    private static final String TOPIC = "Kafka_mapped";

    public void producedata() {

        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Reservations.csv"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                RoomReservationCsv roomReservationCsv = new RoomReservationCsv(Long.parseLong(data[0]), data[1], data[2],
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                kafkaTemplate.send(TOPIC,roomReservationCsv);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV Read");

    }


}
