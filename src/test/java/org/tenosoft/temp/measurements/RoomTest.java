package org.tenosoft.temp.measurements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.repositories.RoomRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = "temp.mes.resource.source=jpa")

public class RoomTest {
    @Autowired
    RoomRepository roomRepository;

    @BeforeEach
    public void TestData(){
        generateTestData();
    }
    private void generateTestData(){
        List<Room>rooms = new ArrayList<>();
        Room room = new Room();
        room.setName("livingroom");
        room.setFloorId(0L);

        RoomTemperatur roomTemperatur = new RoomTemperatur();
        roomTemperatur.setIstTemp(23.5f);
        roomTemperatur.setTime(new Date(System.currentTimeMillis()));
        room.setRoomTemperatur(roomTemperatur);
        roomTemperatur.setRoom(room);


        SollTemperatur sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(24.0f);
        sollTemperatur.setMin(18.0f);
        sollTemperatur.setRoom(room);
        room.setSollTemperatur(sollTemperatur);

        Light light = new Light();
        light.setLightName("Living room Main");
        light.setRoom(room);
        light.setState(0);
        room.getLights().add(light);

        light = new Light();
        light.setLightName("Living room Dining light");
        light.setRoom(room);
        light.setState(0);
        room.getLights().add(light);
        rooms.add(room);


        room = new Room();
        room.setName("Flur");
        room.setFloorId(0L);
        roomTemperatur = new RoomTemperatur();
        roomTemperatur.setIstTemp(23.5f);
        roomTemperatur.setTime(new Date(System.currentTimeMillis()));
        room.setRoomTemperatur(roomTemperatur);
        roomTemperatur.setRoom(room);

        sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(23.0f);
        sollTemperatur.setMin(20.0f);
        sollTemperatur.setRoom(room);
        room.setSollTemperatur(sollTemperatur);

        light = new Light();
        light.setLightName("Flur entrance light");
        light.setRoom(room);
        light.setState(1);
        room.getLights().add(light);

        light = new Light();
        light.setLightName("Flur inner side light");
        light.setRoom(room);
        light.setState(0);
        room.getLights().add(light);

        rooms.add(room);


        roomRepository.saveAll(rooms);

    }

     @Test
     public void findRoomByName(){
        //given
        Room room = roomRepository.findFirstByName("livingroom");
        //Assert
         Assertions.assertEquals(room.getName(),"livingroom");
         room.getName();
         long roomId = room.getId();
        //Assert light

         Assertions.assertEquals(2, room.getLights().size());


         Assertions.assertEquals(room.getLights().size(),2, "The numbber of lights in the room´is not correct");
     }


     @Test
     public void findRoomByExample() {
        Room room = new Room();
        room.setName("Flur");
        room.setFloorId(10L);
         Example<Room> roomExample = Example.of(room);

         Optional<Room>  actual = roomRepository.findOne(roomExample);

          Assertions.assertTrue(actual.isPresent());




     }
    @Test
    public void findRoomsByFloorId(){
        //given
        List<Room>rooms = roomRepository.findRoomsByFloorId(0l);
        //Assert
        //TODO use fetch LAZY mechanismus
        Assertions.assertEquals(rooms.size(),2,"The total number of room should be 2");

    }

    @AfterEach
    public void cleanTables(){
        roomRepository.deleteAll();
    }
}
