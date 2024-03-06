package org.tenosoft.temp.measurements;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.repositories.RoomTempRepository;

@SpringBootTest

public class RoomTemperaturTest {

	RoomTempRepository repository;
	
	@Test
	public void roomtemp() {
		RoomTemperatur roomtemp = new RoomTemperatur(0,23.5);
		roomtemp = repository.save(roomtemp) ;
	}
	
}
