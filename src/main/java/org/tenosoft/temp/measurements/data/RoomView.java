package org.tenosoft.temp.measurements.data;

import java.time.Instant;

public class RoomView {

	String roomName;
	long roomId;
	int lightState;
	double istTemp;
	double sollTemp;
	double minTemp;
	Instant instant;
	
	
	public RoomView() {
		
	}

	

	public RoomView(String roomName, long roomId) {
		super();
		this.roomName = roomName;
		this.roomId = roomId;
	}



	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	
	public long getRoomId() {
		return roomId;
	}


	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}


	public int getLightState() {
		return lightState;
	}


	public void setLightState(int lightState) {
		this.lightState = lightState;
	}


	public double getIstTemp() {
		return istTemp;
	}


	public void setIstTemp(double istTemp) {
		this.istTemp = istTemp;
	}


	public double getSollTemp() {
		return sollTemp;
	}


	public void setSollTemp(double sollTemp) {
		this.sollTemp = sollTemp;
	}


	public double getMinTemp() {
		return minTemp;
	}


	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}


	public Instant getInstant() {
		return instant;
	}


	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	
	

}
