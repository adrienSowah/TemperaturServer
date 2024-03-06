package org.tenosoft.temp.measurements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tenosoft.temp.measurements.Model.SollTemperatur;

public interface SollTempRepository extends JpaRepository<SollTemperatur, Long> {
	
	SollTemperatur FindByRoomId(int roomid);
	SollTemperatur FindBySollTemp(double soll);
	SollTemperatur FindByMin(double min);
	
}