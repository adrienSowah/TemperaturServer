package org.tenosoft.temp.measurements.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.serviceImp.RoomServices;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(properties = "temp.mes.resource.source=jpa")
public class RoomServicesTest {

    @Autowired
    RoomServices roomServices;





    @Test
    public void addRoomTest() {

        List<Room> roomItems = roomServices.getAllRooms();
        for (Room roomItem: roomItems) {
            roomServices.deleteRoomById(roomItem.getId());
        }

        Room room = createRoomTestData();
        roomServices.addRoom(room);
        List<Room> rooms = roomServices.getAllRooms();
        Assertions.assertEquals(rooms.size(), 1);
    }


    @Test
    public void deleteAllRooms() {
        Room aRoom = createRoomTestData();
        roomServices.updateRoom(aRoom);
        List<Room> rooms = roomServices.getAllRooms();
        Assertions.assertFalse(rooms.isEmpty());
        for (Room roomItem: rooms) {
            roomServices.deleteRoomById(roomItem.getId());
        }
        rooms = roomServices.getAllRooms();
        Assertions.assertTrue(rooms.isEmpty());
    }

    private Room createRoomTestData(){
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
        sollTemperatur.setRoom(room);

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

        return room;

    }

    @Test
    public void getRoomById(){
        Room aRoom = createRoomTestData();
        roomServices.updateRoom(aRoom);

        List<Room> rooms = roomServices.getAllRooms();
        Long roomId = rooms.get(0).getId();

        Room room = roomServices.getRoomById(roomId);

        Assertions.assertEquals(room.getName(),"livingroom");

        for (Room roomItem: rooms) {
            roomServices.deleteRoomById(roomItem.getId());
        }


    }

    @Test
    public void getSollTempretaurById(){
        Room aRoom = createRoomTestData();
        aRoom  = roomServices.updateRoom(aRoom);

        Long sollTemp = aRoom.getSollTemperatur().getId();

        SollTemperatur sollTemperatur = roomServices.getSollTemperaturById(aRoom.getId());

        Assertions.assertEquals(sollTemperatur.getSoll(),24);

        roomServices.deleteRoomById(aRoom.getId());

    }

    @Test
    public void getRoomTempByID(){
        Room aRoom = createRoomTestData();
        roomServices.updateRoom(aRoom);
        List<Room> rooms = roomServices.getAllRooms();
        RoomTemperatur roomTemp = rooms.get(0).getRoomTemperatur();


        RoomTemperatur roomTemperatur = roomServices.getRoomTemperatureById(roomTemp.getId());

        Assertions.assertEquals(roomTemp.getIstTemp(),23.5);
        for (Room roomItem: rooms) {
            roomServices.deleteRoomById(roomItem.getId());
        }
    }

    @Test
    public void getLightById(){
        Room aRoom = createRoomTestData();
        Room savedRoom = roomServices.updateRoom(aRoom);


       List<Light> light = roomServices.lightByID(savedRoom.getId());

       Assertions.assertEquals(light.size(),2);

       roomServices.deleteRoomById(savedRoom.getId());

    }

    @Test
    public void UpdateRoom(){
        Room aRoom  = createRoomTestData();
        aRoom = roomServices.updateRoom(aRoom);

        Room room = roomServices.getRoomById(aRoom.getId());
        Room newRoom = room;
        newRoom.setName("living room 2");
        roomServices.updateRoom(newRoom);

        Assertions.assertFalse(room.getName() == roomServices.getRoomById(aRoom.getId()).getName());
        roomServices.deleteRoomById(aRoom.getId());


    }

    @Test
    public void deleteRoomById(){
        Room aRoom =  createRoomTestData();
        aRoom = roomServices.updateRoom(aRoom);

        roomServices.deleteRoomById(aRoom.getId());

        Assertions.assertEquals(roomServices.getAllRooms().size(),0);
    }


    @Test
    public void getRoomByExampleServiceTest() {
        Room aRoom =  createRoomTestData();
        aRoom = roomServices.updateRoom(aRoom);
        Room expected = new Room();
        expected.setName("livingroom");
        Room actual = roomServices.getRoomByExample(expected);

        Assertions.assertEquals(actual.getName(),expected.getName());

        roomServices.deleteRoomById(aRoom.getId());

    }
}
