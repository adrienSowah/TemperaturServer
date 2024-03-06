package org.tenosoft.temp.measurements.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.dao.DaoTemperature;
import org.tenosoft.temp.measurements.dao.IRoomService;
import org.tenosoft.temp.measurements.data.RoomView;

@Controller

public class RoomController {
	
	@Autowired
	DaoTemperature daoTemperature;
	
	
	 
	 
	 
	 
	  
	 @GetMapping(path="/singleRoomByIndex/{name}")
	 public ResponseEntity<Room>  getRoomByName(@PathVariable("name") String name) {
		Room room = daoTemperature.getRoomByName(name);
		
		 		 
		 return new ResponseEntity<>(room, HttpStatus.OK);

	 }
	 
	 
	@GetMapping(path = "/getAllRooms")
	public ResponseEntity<List<Room>>getAllRooms(){
		
		List<Room>rooms = daoTemperature.getAvailableRooms(); 
		
		 return new ResponseEntity<>(rooms, HttpStatus.OK);
		
	}
	 
	@GetMapping(path = "/getTemp")
	public ResponseEntity<List<RoomTemperatur>>getAllRoomTempreaturs(){
		
		List<RoomTemperatur>rooms = daoTemperature.getAvailableRoomTemperatur(); 
		
		 return new ResponseEntity<>(rooms, HttpStatus.OK);
		
	}
	
@DeleteMapping(path="/DeleteRoom/{RoomID}")
	public void deleteRoom(@PathVariable("RoomID")int RoomId) {
		
		
	}
	
	 @GetMapping(path="/floor/{floorSelected}")
	  public @ResponseBody List<Room> getAllrooms(@PathVariable("floorSelected")int floorSelected) {
	    // This returns a JSON or XML with the users
	    return null;
	  }
	 /*
	 @PostMapping(path="/addRoom ") // Map ONLY POST Requests
	  public @ResponseBody Floor addNewRoom (@RequestParam Room room, @RequestParam Floor floor) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	
		floor.addRoom(room);
	    return floor;
	  }
	  */
	 
	 @PostMapping(value ="/changeTempretur/{roomID}/{temp}")
	 public ResponseEntity<Room> changeTempretur(@PathVariable Integer roomID, @PathVariable double temp) {
//		 if (roomID != null) {
//			 Room room = Rooms.get(roomID);
//			 room.setTempShould(temp);
//			 return new ResponseEntity<>(room, HttpStatus.OK);     
//		 }else {
//			 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); 
//		 }
//		 
//		
//		 
		 
		 return null;
		
		 
		 
	 }
	 
	 @GetMapping(path="/heatOn/{floor}")
	 public void HeaterOn ( @PathVariable("floor")int floor) {
	//	 house.get(floor).setHeat(true);
	 }
	 
	 @GetMapping(path="/heatOff/{floor}")
	 public void HeaterOff ( @PathVariable("floor")int floor) {
	//	 house.get(floor).setHeat(false);
	 }
	 
	 @GetMapping(path = "/getRoomInfo/{id}")
	 public ResponseEntity<RoomView> getRoomAllInfo( @PathVariable("id")long  id) {
		
		RoomView roomview =  daoTemperature.getAllInfo(id);
		 
		 
		return new ResponseEntity (roomview, HttpStatus.OK);
	 }
	 
}

