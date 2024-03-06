package org.tenosoft.temp.measurements.dao;

import java.util.List;

import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.data.RoomView;

public interface IRoomService {

	
	String GET_ALL_ROOMS = "SELECT * FROM ROOM ";
	
	String SELECT_ROOM_BY_NAME = "Select * from Room Where name = ?";
	String SELECT_ROOM_BY_ID = "Select * from Room Where id = ?";
	String SELECT_ROOM_BY_FLOOR_ID = "Select * from Room Where floorid = ?";
	String DELETE_ROOM_BY_ID = "Delet * from Room Where id = ?";
	String SELECT_ALL_INFO_ROOM = "select distinct r.id , r.name, l.state,rt.isttemp,sol.solltemp from room as r, light as l, roomtemp as rt,solltemp as sol where (r.id=l.roomid and r.id=sol.roomid and r.id=?)  ";
	String SELECT_LIGHT_BY_ROOM_ID = "Select * from light where id = ?";
	
	
	List<Room> getAvailableRooms();
	Room getRoomByName(String name);
	
	void DeleteRoomById(long roomId);
	Room getRoomById(long roomId);
	Light getLightByRoomId(long roomId);
	
	List<Room> getRoomsByFloorId(long id);
	RoomView getAllInfo(long roomId);
	RoomView retrieveRoomTempLightByRoomId(long roomId);
}
