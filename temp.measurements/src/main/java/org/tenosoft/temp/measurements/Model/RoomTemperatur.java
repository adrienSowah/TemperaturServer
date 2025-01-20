package org.tenosoft.temp.measurements.Model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="roomTemp")
public class RoomTemperatur implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;


	@OneToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;
	private double istTemp;
	
	@Column(name ="uhrzeit")
	private Date time;
	
	public RoomTemperatur() {
		
	}
	public RoomTemperatur(long id,double istTemp) {
		this.id = id;
		this.istTemp = istTemp;
	}
	@JsonIgnore
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@JsonGetter("IstTemp")
	public double getIstTemp() {
		return istTemp;
	}
	public void setIstTemp(double istTemp) {
		this.istTemp = istTemp;
	}
	@JsonIgnore
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	@JsonManagedReference
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	/*
	@Override
	public String toString() {
		return "RoomTemperatur{" +
				"id=" + id +
				", room=" + room +
				", istTemp=" + istTemp +
				", time=" + time +
				'}';
	}
	*/
}
