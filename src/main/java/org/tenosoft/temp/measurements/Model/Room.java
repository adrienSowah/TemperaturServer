package org.tenosoft.temp.measurements.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(String name, long floorid) {
		super();
		this.name = name;
		this.floorid = floorid;
	}
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private long floorid;
	
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFloorid() {
		return floorid;
	}
	public void setFloorid(long floorid) {
		this.floorid = floorid;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
