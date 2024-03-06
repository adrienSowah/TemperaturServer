package org.tenosoft.temp.measurements.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;

public interface LightRepository extends JpaRepository<Light,Long> {
		
	 Light FindByState(int state);
	 
	 Light FindByRoomId(int roomid);
	 
	 
}

