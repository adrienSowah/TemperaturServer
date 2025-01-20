package org.tenosoft.temp.measurements.serviceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tenosoft.temp.measurements.Model.*;
import org.tenosoft.temp.measurements.controller.RoomData;
import org.tenosoft.temp.measurements.interfaces.IRoomService;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;

import java.util.List;

@Service
public class   RoomServices {
    /*
    @Autowired
    DaoRoom daoRoom;
    @Autowired
    DaoTemperature daoTemperature;
    */
    Logger logger = LoggerFactory.getLogger(RoomServices.class);
    IRoomService iRoomService;
    ITemperaturServices iTemperaturServices;
   public RoomServices(@Qualifier("RoomServiceBean")IRoomService roomServiceBean, @Qualifier("TemperatureServiceBean") ITemperaturServices iTemperaturServices) {
     this.iRoomService = roomServiceBean;
     this.iTemperaturServices = iTemperaturServices;
   }

    public List<Room> getAllRooms() {
       logger.debug("Will retrieve all rooms");
       List<Room>allRooms =  iRoomService.getAvailableRooms();
       logger.info("Total rooms retrieve {} " , allRooms.size());

        return allRooms;
    }

    public Room getRoomById (long roomId) {
        logger.debug("Will invoke getRoomById with roomId {} ", roomId);
       Room room =  iRoomService.getRoomById(roomId);
       if(room != null){
           logger.info("Room retrieved is {} ", room);
           logger.info( " Room {}, with id {}, description {}",room.getName(), room.getId(),room.getDescription());
       }else{
           logger.error("Room not found");
       }

        return room;
    }

    public Room getRoomByName (String roomName) {
        logger.debug("Will invoke getRoomByName with room name {} ", roomName);
        Room room =  iRoomService.getRoomByName(roomName);
        if(room != null){
            logger.info("Room retrieved is {} ", room);
            logger.info( " Room {}, with id {}, description {}",room.getName(), room.getId(),room.getDescription());
        }else{
            logger.error("Room not found");
        }

        return room;
    }

    public RoomTemperatur getRoomTemperatureById (long Id) {
       logger.info("Will invoke with roomId {}", Id);
       RoomTemperatur roomTemperatur = iTemperaturServices.getRoomTempByRoomId(Id);
       if(roomTemperatur !=null){
           logger.info("retrived RoomTemperatur: {}",roomTemperatur);
       }else{
           logger.error("no temperatur for this ID");
       }
        return roomTemperatur;
    }

    public SollTemperatur getSollTemperaturById(long roomId){
       logger.info("will retrive soll Temperatur");
    SollTemperatur sollTemperatur = iTemperaturServices.getSollTempByRoomId(roomId);
    if(sollTemperatur != null){
      logger.info("Soll Temperatur retrieved: {}",sollTemperatur);
    }else{
        logger.error("no soll Temperatur for this RoomId");
    }
        return sollTemperatur;
    }

    public List<Light> lightByID(long roomId){
       List<Light> light = iRoomService.getLightByRoomId(roomId);
        if(light !=null){
            logger.info("Light from Room: {}",light);
        }else {
            logger.error("room not found");
        }
        return light;
    }
    public List<RoomTemperatur> getallTemperaturs(){
       List<RoomTemperatur>allTemperaturs = iTemperaturServices.getAvailableRoomTemperatur();
       if(allTemperaturs != null){
           for(RoomTemperatur roomTemp : allTemperaturs  ){
            logger.info("room Temperatur: {}",roomTemp);
           }
       }else {
           logger.error("no Temperaturs found");
       }
   return allTemperaturs;
    }
public void addRoom(Room room){
 iRoomService.insertRoom(room);
}

public Light addLight(Light light){
      light =  iRoomService.addLight(light);
      return light;
}

public Room updateRoom(Room room ) {
      return iRoomService.updateRoom(room);
}

public void deleteRoomById(long roomId) {
       iRoomService.deleteRoomById(roomId);

}

public RoomData getAllInfo(long roomId) {
       return iRoomService.getAllInfo(roomId);
}

public void deleteRoomByName(String name){
       iRoomService.getRoomByName(name);
}
}
