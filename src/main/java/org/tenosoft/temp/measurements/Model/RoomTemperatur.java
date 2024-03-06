package org.tenosoft.temp.measurements.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomTemp")
public class RoomTemperatur {
	
	@Id
	@GeneratedValue
	private long id;
	private long roomId;
	private double istTemp;
	
	@Column(name ="uhrzeit")
	private Date time;
	
	public RoomTemperatur() {
		
	}
	public RoomTemperatur(long id,double istTemp) {
		this.id = id;
		this.istTemp = istTemp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public double getIstTemp() {
		return istTemp;
	}
	public void setIstTemp(double istTemp) {
		this.istTemp = istTemp;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
