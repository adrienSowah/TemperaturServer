package org.tenosoft.temp.measurements.Model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
public class SollTemperatur implements Serializable {
	@Id
	@GeneratedValue
private long id;


@OneToOne
@JoinColumn(name = "room_id", referencedColumnName = "id")
private Room room;
@Column(name = "solltemp")
private double soll;
@Column(name = "mintemp")
private double min;
@JsonIgnore
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

@JsonGetter("sollTemp")
public double getSoll() {
	return soll ;
}
public void setSoll(double soll) {
	this.soll = soll;
}
@JsonGetter("MinTemp")
public double getMin() {
	return min;
}
public void setMin(double min) {
	this.min = min;
}

/*
	@Override
	public String toString() {
		return "SollTemperatur{" +
				"id=" + id +
				", room=" + room +
				", soll=" + soll +
				", min=" + min +
				'}';
	}
*/
	@JsonIgnore
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
