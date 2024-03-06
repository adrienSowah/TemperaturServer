package org.tenosoft.temp.measurements.dao;

import java.util.List;

import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;

public interface ITemperaturServices {
	
	String GET_ROOM_TEMPERATUR_BY_ID = "Select * from roomtemp where id = ? " ;
	String GET_SOLL_TEMPERATUR_BY_ID = "Select * from solltemp where id = ? " ;
	String UPDATE_ROOM = "UPDATE ROOMTEMP SET ISTTEMP= ? WHERE ROOMID=? ";
	String GET_ALL_ROOM_TEMPERATURS = "Select * from roomtemp";
	String GET_ALL_SOLL_TEMPERATURS = "Select * from solltemp";
	
	boolean updateIstTemperature(int roomId, double istTemp);
	List<RoomTemperatur> getAvailableRoomTemperatur();
	List<SollTemperatur> getAvailableRoomSollTemperatur();
	
	RoomTemperatur getRoomTempByRoomId(long roomId); 
	SollTemperatur getSollTempByRoomId(long roomId);
	
}