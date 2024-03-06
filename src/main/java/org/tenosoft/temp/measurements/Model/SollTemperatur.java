package org.tenosoft.temp.measurements.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SollTemperatur {
	@Id
	@GeneratedValue
private long id;
private long roomId;
@Column(name = "solltemp")
private double soll;
@Column(name = "mintemp")
private double min;
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
public double getSoll() {
	return soll;
}
public void setSoll(double soll) {
	this.soll = soll;
}
public double getMin() {
	return min;
}
public void setMin(double min) {
	this.min = min;
}


}
