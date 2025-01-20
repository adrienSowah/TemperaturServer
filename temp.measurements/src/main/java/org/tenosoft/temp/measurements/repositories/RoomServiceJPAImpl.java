package org.tenosoft.temp.measurements.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.tenosoft.temp.measurements.Model.*;
import org.tenosoft.temp.measurements.controller.RoomData;
import org.tenosoft.temp.measurements.interfaces.IRoomService;

import java.util.List;
import java.util.Optional;

@ConditionalOnProperty(
        value="temp.mes.resource.source",
        havingValue = "jpa",
        matchIfMissing = false)
@Configuration
public class RoomServiceJPAImpl implements IRoomService{


    private final RoomRepository roomRepository;
   private final LightRepository lightRepository;
    private final RoomTempRepository roomTempRepository;


    public RoomServiceJPAImpl(RoomRepository roomRepository, LightRepository lightRepository, RoomTempRepository roomTempRepository) {
        this.roomRepository = roomRepository;
        this.lightRepository = lightRepository;
        this.roomTempRepository = roomTempRepository;
    }
    @Override
    public List<Room>  getAvailableRooms() {

       return roomRepository.findAll();

    }

    @Override
    public Room getRoomByName(String name) {
        return roomRepository.findFirstByName(name);

    }

    @Override
    public void deleteRoomById(long roomId) {
       roomRepository.deleteById(roomId);
    }

    @Override
    public void deleteByName(String name) {
        roomRepository.deleteByName(name);
    }

    @Override
    public List<Light> getLightByRoomId(long roomId) {
        return  lightRepository.findByRoomId(roomId);

    }

    @Override
    public Light addLight(Light light) {
        return lightRepository.save(light);
    }

    @Override
    public List<Room> getRoomsByFloorId(long id) {
       return roomRepository.findRoomsByFloorId(id);

    }

    @Override
    public RoomData getAllInfo(long roomId) {
        RoomData result = new RoomData();
       Optional<Room> rootItemOptional = roomRepository.findById(roomId);

       if (rootItemOptional.isPresent()) {
           Room roomItem = rootItemOptional.get();
           List<Light> light = lightRepository.findByRoomId(roomId);
           Optional<RoomTemperatur> roomTemp = roomTempRepository.findById(roomId);
           result.setRoomId(roomId);
           // result.setLights(light);
            result.setIstTemp(roomTemp.get().getIstTemp());
            result.setRoomName(roomItem.getName());
            //result.setFloorId(roomItem.getFloorId());

       }
        return result ;
    }

    @Override
    public Room getRoomById(long roomId) {
        Optional<Room> rootItemOptional = roomRepository.findById(roomId);
        Room result = null;
        if (rootItemOptional.isPresent()) {
            result = rootItemOptional.get();

        }
      return  result;

    }

    @Override
   public void insertRoom(Room room) {
        roomRepository.save(room);
   }

   @Override
    public Room updateRoom(Room room){
       return roomRepository.save(room);
   }

}