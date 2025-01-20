package org.tenosoft.temp.measurements.services;

import org.junit.jupiter.api.Assertions;
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
        Room room = createRoomTestData();
        roomServices.addRoom(room);
        List<Room> rooms = roomServices.getAllRooms();
        Assertions.assertEquals(rooms.size(), 2);
    }


    @Test
    public void deleteAllRooms() {
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
        room.setFloorId(0);

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

        return room;

    }

    @Test
    public void getRoomById(){

        Room room = roomServices.getRoomById(688);

        Assertions.assertEquals(room.getName(),"livingroom");

    }

    @Test
    public void getSollTempretaurById(){
        SollTemperatur sollTemperatur = roomServices.getSollTemperaturById(688);

        Assertions.assertEquals(sollTemperatur.getSoll(),24);
    }

    @Test
    public void getRoomTempByID(){
        RoomTemperatur roomTemperatur = roomServices.getRoomTemperatureById(688);

        Assertions.assertEquals(roomTemperatur.getIstTemp(),23.5);
    }

    @Test
    public void getLightById(){
       List<Light> light = roomServices.lightByID(688);

       Assertions.assertEquals(light.size(),2);
    }

    @Test
    public void UpdateRoom(){
        Room room = roomServices.getRoomById(688);
        Room newRoom = room;
        newRoom.setName("living room 2");
        roomServices.updateRoom(newRoom);

        Assertions.assertFalse(room.getName() == roomServices.getRoomById(688).getName());


    }

    @Test
    public void deleteRoomById(){
        roomServices.deleteRoomById(688);

        Assertions.assertEquals(roomServices.getAllRooms().size(),1);
    }

}
