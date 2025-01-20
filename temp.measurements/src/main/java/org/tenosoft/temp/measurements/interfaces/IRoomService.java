package org.tenosoft.temp.measurements.interfaces;

import java.util.List;

import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.controller.RoomData;

public interface IRoomService {


	Room getRoomByName(String name);
	
	void deleteRoomById(long roomId);

	void deleteByName(String name);

	List<Light> getLightByRoomId(long roomId);

	Light addLight(Light light);
	
	List<Room> getRoomsByFloorId(long id);
	RoomData getAllInfo(long roomId);

	Room getRoomById(long roomId);

	void insertRoom(Room room);
	Room updateRoom(Room room);

	List<Room> getAvailableRooms();

}
