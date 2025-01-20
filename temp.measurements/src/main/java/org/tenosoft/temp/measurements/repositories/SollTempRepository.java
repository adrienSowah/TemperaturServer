package org.tenosoft.temp.measurements.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tenosoft.temp.measurements.Model.SollTemperatur;

import java.util.List;

@Repository
@ConditionalOnProperty(
		value="temp.mes.resource.source",
		havingValue = "jpa",
		matchIfMissing = false)

public interface SollTempRepository extends JpaRepository<SollTemperatur, Long> {
	
	SollTemperatur findByRoomId(long roomid);
	List<SollTemperatur> findBySoll(double soll);
	List<SollTemperatur> findByMin(double min);
	
}