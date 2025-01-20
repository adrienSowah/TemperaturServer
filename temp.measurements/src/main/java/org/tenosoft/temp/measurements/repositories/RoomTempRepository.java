package org.tenosoft.temp.measurements.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;

@Repository
@ConditionalOnProperty(
		value="temp.mes.resource.source",
		havingValue = "jpa",
		matchIfMissing = false)
public interface RoomTempRepository extends JpaRepository<RoomTemperatur, Long>{

	List<RoomTemperatur> findByIstTemp(double istTemp);
	List<RoomTemperatur> findByTime(Date time);
}
