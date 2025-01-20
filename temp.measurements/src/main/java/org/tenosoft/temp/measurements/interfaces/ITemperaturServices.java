package org.tenosoft.temp.measurements.interfaces;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;


public interface ITemperaturServices {
	

	
	void updateIstTemperature(int roomId, double istTemp);
	List<RoomTemperatur> getAvailableRoomTemperatur();
	List<SollTemperatur> getAvailableRoomSollTemperatur();

	void updateSollTemperature(SollTemperatur sollTemperatur);
	
	RoomTemperatur getRoomTempByRoomId(long roomId); 
	SollTemperatur getSollTempByRoomId(long roomId);

}