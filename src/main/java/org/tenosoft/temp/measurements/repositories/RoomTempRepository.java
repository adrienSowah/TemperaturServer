package org.tenosoft.temp.measurements.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;

public interface RoomTempRepository extends JpaRepository<RoomTemperatur, Long>{

	RoomTemperatur FindByRoomId(int roomid);
	RoomTemperatur FindByIstTemp(double istTemp);
	RoomTemperatur FindByTime(Date time);
}
