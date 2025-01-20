package org.tenosoft.temp.measurements;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.repositories.RoomTempRepository;
import org.tenosoft.temp.measurements.serviceImp.RoomServices;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest(properties = "temp.mes.resource.source=jpa")
 public class RoomTemperaturTest {

	@Autowired
	RoomTempRepository roomTempRepository;

	@Autowired
	RoomServices roomServices;

	@BeforeEach
	public void expectedResults(){
		uploadTestData();
	}

@Test
   public  void getAllRoomTeperatures() {
	 List<RoomTemperatur> rooms =   roomTempRepository.findAll();
	 Assertions.assertEquals(rooms.size(),5);
   }


   @Test
   public void addNewRoomTempertur(){
	//given a room
	   RoomTemperatur roomTemperatur = new RoomTemperatur();
	   roomTemperatur.setIstTemp(37.0f);
	  //TODO roomTemperatur.setRoomId(3);
	      //action
	   RoomTemperatur roomTemperatur1Saved = roomTempRepository.save(roomTemperatur);

	   //Assert
	   Assertions.assertNotNull(roomTemperatur1Saved);
	   List<RoomTemperatur> rooms =   roomTempRepository.findAll();
	   Assertions.assertEquals(rooms.size(),6);

   }

@Test
public void findRoomTemperaturByRoomID(){
	//given
	Optional<RoomTemperatur> roomTemperatur = roomTempRepository.findById(3L);
	//assert
	//TODO Assertions.assertEquals(roomTemperatur.getRoomId(),3);
}

@Test
public void deleteRoomTempById(){
		//given
	    Optional<RoomTemperatur> roomToDelete = roomTempRepository.findById(1L);

		//assert
	   Assertions.assertNotNull(roomToDelete,"The room to deleted must exist");
		roomTempRepository.delete(roomToDelete.get());
		//Assert
		Assertions.assertEquals(roomTempRepository.count(),4);
		Optional<RoomTemperatur> roomAfterDelete = roomTempRepository.findById(1L);
		Assertions.assertNull(roomAfterDelete, "The roomTemperature object must be null beceause it is already deleted");

}

@Test
public void UpdateIstTemperatur(){
		//given
		List<RoomTemperatur> roomTemperaturs = roomTempRepository.findByIstTemp(26.6);
		RoomTemperatur roomTemperatur = roomTemperaturs.get(0);
		Double oldTemperatur = roomTemperatur.getIstTemp();
		roomTemperatur.setIstTemp(40);
	roomTemperatur = roomTempRepository.save(roomTemperatur);
		//Assert
		Assertions.assertNotEquals(oldTemperatur,roomTemperatur.getIstTemp());
		Assertions.assertEquals(roomTemperatur.getIstTemp(),40);
}

@Test
public void findIstTemperatur(){
		//given
		List<RoomTemperatur> roomTemperaturs = roomTempRepository.findByIstTemp(26.6f);
		//Assert
		Assertions.assertEquals(roomTemperaturs.size(),2);
}
@Test
public void findByDate(){
		//given
		List<RoomTemperatur>roomTemperaturs = roomTempRepository.findByTime(new Date(System.currentTimeMillis()));
		//Assert
		Assertions.assertEquals(roomTemperaturs.size(),5);

}

	//@Test
	public void roomtempById(){
		//Given

		//Assert


	}

	//@Test
	public void sollTempById(){
		//given

		//Assert

	}

//@Test
	public void changeTemp(){

}
//@Test
	public void addRoom(){

}

@AfterEach
public void cleanTables() {
	roomTempRepository.deleteAll();
}

private void uploadTestData() {

    List<RoomTemperatur> data = new ArrayList<>();
	RoomTemperatur item = new RoomTemperatur();
	item.setTime(new Date(System.currentTimeMillis()));
	item.setIstTemp(25.6f);
	//TODO item.setRoomId(1L);
	data.add(item);

	item = new RoomTemperatur();
	item.setTime(new Date(System.currentTimeMillis()));
	item.setIstTemp(26.6f);
	//TODO item.setRoomId(2L);
	data.add(item);

	item = new RoomTemperatur();
	item.setTime(new Date(System.currentTimeMillis()));
	item.setIstTemp(28.6f);
//TODO   	item.setRoomId(3L);
	data.add(item);

	item = new RoomTemperatur();
	item.setTime(new Date(System.currentTimeMillis()));
	item.setIstTemp(30.6f);
	//TODO item.setRoomId(4L);
	data.add(item);

	item = new RoomTemperatur();
	item.setTime(new Date(System.currentTimeMillis()));
	item.setIstTemp(26.6f);
	//TODO item.setRoomId(5L);
	data.add(item);
	roomTempRepository.saveAll(data);
}
}