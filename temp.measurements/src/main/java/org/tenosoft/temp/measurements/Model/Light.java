package org.tenosoft.temp.measurements.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Light implements Serializable   {
	@Id
	@GeneratedValue
	private long id;

	@JsonProperty("lightName")
    private String lightName;


	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	@JsonProperty("state")
	private int state;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Light{" +
				"id=" + id +
				", lightName='" + lightName + '\'' +
				", room=" + room +
				", state=" + state +
				'}';
	}


	//@JsonBackReference
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getLightName() {
		return lightName;
	}

	public void setLightName(String lightName) {
		this.lightName = lightName;
	}
}
