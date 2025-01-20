package org.tenosoft.temp.measurements.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tenosoft.temp.measurements.Model.*;

import org.tenosoft.temp.measurements.serviceImp.RoomServices;
import org.tenosoft.temp.measurements.serviceImp.TemperaturServices;

import java.util.ArrayList;
import java.util.List;


@Controller
public class  RoomController {
	
	RoomServices roomServices;
	TemperaturServices temperaturServices;

    public RoomController(RoomServices roomServices, TemperaturServices temperaturServices) {
		this.roomServices = roomServices;
		this.temperaturServices = temperaturServices;
	}


	Logger logger = LoggerFactory.getLogger(RoomController.class);



	@GetMapping(path = "/getAllRooms",produces = "application/json")
	public ResponseEntity<List<RoomData>>getAllRooms(){

		 List<Room> rooms = roomServices.getAllRooms();;
		 List<RoomData> data = new ArrayList<>();
		 try {
			 for (Room rootItem : rooms) {
				 logger.info("Room with Id {} has the temp {}", rootItem.getId(), rootItem.getName());
				 RoomData rdata = new RoomData(rootItem.getId(), rootItem.getName(), rootItem.getDescription());
				 double sollTemp = rootItem.getSollTemperatur() != null ? rootItem.getSollTemperatur().getSoll(): 0.0d;
				 double istTem  = rootItem.getRoomTemperatur() != null ? rootItem.getRoomTemperatur().getIstTemp(): 0.0d;
				 rdata.setSollTemp(sollTemp);
				 rdata.setIstTemp(istTem);
				 data.add(rdata);
			 }
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return new ResponseEntity<>(data, HttpStatus.OK);
	} 

	@GetMapping(path = "/getallTemp")
	public ResponseEntity<List<RoomTemperatur>> getAllRoomTempreaturs(){

		List<RoomTemperatur>allTemperaturs = roomServices.getallTemperaturs();

		return new ResponseEntity<>(allTemperaturs, HttpStatus.OK);
	}

@DeleteMapping(path="/deleteRoom/{roomID}",produces = "application/json")
	public ResponseEntity<String> deleteRoom(@PathVariable("roomID")int roomId) {

	roomServices.deleteRoomById(roomId);
	return new ResponseEntity<>("has been Deleted",HttpStatus.OK);
	}

	@DeleteMapping (path="/deleteRoomByName/{name}",produces = "application/json")
	public ResponseEntity<String> deleteRoomByName(@PathVariable("name")String name) {

		roomServices.deleteRoomByName(name);
		return new ResponseEntity<>("the room with the name:" +name +" has been deleted",HttpStatus.OK);
	}

	 @GetMapping(path="/floor/{floorId}")
	  public @ResponseBody List<Room> getAllrooms(@PathVariable("floorId")int floorSelected) {
	    // This returns a JSON or XML with the users

	    return null;
	  }

	 @PutMapping(path ="/changeTempretur/{roomID}/{temp}")
	 public ResponseEntity<RoomTemperatur> changeTempretur(@PathVariable Integer roomID, @PathVariable double temp) {
		 if (roomID != null) {

 			RoomTemperatur temperature = roomServices.getRoomTemperatureById(roomID);
			 temperature.setIstTemp(temp);

			 temperaturServices.updateIstTemperature(roomID,temp);



			 return new ResponseEntity<>(temperature, HttpStatus.OK);
	 }else {
		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	 }

	 }
	@PutMapping(path = "/changeSollTemp/{newTemp}", consumes = "applicatin/json",produces = "application/json")
public ResponseEntity<SollTemperatur> changeSollTempretur(@RequestBody SollTemperatur sollTemperatur,@PathVariable double newTemp) {
		sollTemperatur.setSoll(newTemp);
		temperaturServices.updateSollTemperature(sollTemperatur);
		return new ResponseEntity<>(sollTemperatur, HttpStatus.OK);
	}

 @PostMapping(value = "/addNewRoom", consumes = "application/json", produces = "application/json")
 public ResponseEntity<String> addRoom(@RequestBody RoomData roomdata){
		Room room = new Room();
		room.setName(roomdata.roomName);
		room.setDescription(roomdata.getDescription());

        roomServices.addRoom(room);
		return  new ResponseEntity<>("Successfully saved", HttpStatus.OK);

 }

	 @GetMapping(path="/heatOn/{floor}")
	 public void HeaterOn ( @PathVariable("floor")int floor) {

	 }
	 
	 @GetMapping(path="/heatOff/{floor}")
	 public void HeaterOff ( @PathVariable("floor")int floor) {

	 }

	 @GetMapping(path = "/getRoomInfo/{id}" , produces = "application/json", consumes = "application/json")
	 public ResponseEntity<RoomData> getRoomAllInfo(@PathVariable("id")long  id) {
	   logger.debug("Will retrieve all information about a room with the id {}",id);

		     RoomData roomData =  roomServices.getAllInfo(id);
		if ( roomData != null) {
			logger.info("room: " + roomData.getRoomName()  + " istTemp: " + roomData.getIstTemp() + " sollTemp: " + roomData.getSollTemp());
		}else {

			logger.error("Could not retrieve room views with the id {}", id);
		}
		return new ResponseEntity<>  (roomData, HttpStatus.OK);
	 }

	 @GetMapping(path = "/getTemperaturById/{id}" )
	 public ResponseEntity<RoomTemperatur>getRoomTemperaturById(@PathVariable("id") long id){
		RoomTemperatur roomTemperatur = roomServices.getRoomTemperatureById(id);

		return new ResponseEntity<>(roomTemperatur, HttpStatus.OK);
	}

	@PostMapping(value = "/addLight",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Light>addLight(@RequestBody  Light light){
		Room roomItem = light.getRoom();
		roomItem = roomServices.getRoomByName(roomItem.getName());

		if (roomItem != null) {
			logger.info("Room with the id {} retrieved ", roomItem.getId());
			light.setRoom(roomItem);

		}

		Light savedlight =  roomServices.addLight(light);

		return new ResponseEntity<>(savedlight, HttpStatus.OK);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullpointerException(NullPointerException ex){

		return new ResponseEntity<>("Requestbody is incorrect",HttpStatus.BAD_REQUEST);
	}

}

