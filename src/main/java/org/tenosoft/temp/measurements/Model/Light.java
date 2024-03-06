package org.tenosoft.temp.measurements.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Light {
	@Id
	@GeneratedValue
	private long id;
	private long roomId;
	private int state;
	
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
    public String toString() {
        return "Light [id=" + id + ", roomId=" + roomId + ", state=" + state + "]";
    }

}
