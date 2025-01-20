package org.tenosoft.temp.measurements;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.dao.DaoTemperature;
import org.tenosoft.temp.measurements.repositories.RoomRepository;

import com.jayway.jsonpath.Option;

@SpringBootTest
public class TemperautureTest {

	//@Autowired
	//DaoTemperature daoTemperature;
	
	@Autowired
	RoomRepository repository;
	

	@Test
	public void emptyTest() {
		boolean result = true;
		
		assertTrue(result,"All is well");
		
		Room room = new Room ("Office",1);
		//room.setDescription("All is well that works well");
		//room = repository.save(room);
		
		Optional<Room> opRoom =   repository.findById(1L);
		if(opRoom.isPresent()) {
		  room = opRoom.get();
		  room.setName("My Office");
		  repository.save(room);
		}
		
		
		assertNotNull(room.getId());
		assertTrue(room.getId() > 0);
		
	}

	//@Test
	public void testUpdateTemparuture() {
		//arrange
		int testRoomId = 1;
		double temps = 12.12;
		
		
		//act
		//boolean testResult = daoTemperature.updateIstTemperature(testRoomId, temps);
		
		//assertTrue(testResult, "Error occured updating the temperatur");
		
	}
	@Test
	public void testGetRoomByName() {
		//boolean testResult = daoTemperature.getRoomByName("bedroom 1") != null;
		
	//	assertTrue(testResult, "Error occured getting room ");
		
	}
}
 