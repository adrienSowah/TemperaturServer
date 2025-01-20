package org.tenosoft.temp.measurements.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
@Repository
@ConditionalOnProperty(
		value="temp.mes.resource.source",
		havingValue = "jpa",
		matchIfMissing = false)
public interface LightRepository extends JpaRepository<Light,Long> {
		
	 List<Light> findByState(int state);
	 
	 List<Light> findByRoomId( long roomid);


	 
}

