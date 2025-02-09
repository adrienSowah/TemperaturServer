package org.tenosoft.temp.measurements.Model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class  Room implements Serializable {

	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(String name, long floorid) {
		super();
		this.name = name;
		this.floorId = floorid;
	}
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Long id;
//@JsonProperty("name")
	private String name;

@JsonProperty("floorid")
	@Column(name="floorid")
	private Long floorId;

@JsonProperty("description")
	private String description;

@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "room")
	private RoomTemperatur roomTemperatur;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "room")
	private SollTemperatur sollTemperatur;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "room")
	private Set<Light> lights;



	@JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("rooName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public Long getFloorId() {
		return floorId;
	}
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	@JsonGetter("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonManagedReference
	public RoomTemperatur getRoomTemperatur() {
		return roomTemperatur;
	}

	public void setRoomTemperatur(RoomTemperatur roomTemperatur) {
		this.roomTemperatur = roomTemperatur;
	}

	@JsonManagedReference
	public SollTemperatur getSollTemperatur() {
		return sollTemperatur;
	}

	public void setSollTemperatur(SollTemperatur sollTemperatur) {
		this.sollTemperatur = sollTemperatur;
	}

         @JsonManagedReference
	public Set<Light> getLights() {
		if (lights == null) {
			lights = new HashSet<>();
		}

		return lights;
	}

	public void setLights(Set<Light> lights) {
		this.lights = lights;
	}

	@Override
	public String toString() {
		return "Room{" +
				"id=" + id +
				", name='" + name + '\'' +
				", floorId=" + floorId +
				", description='" + description + '\'' +
				", roomTemperatur=" + roomTemperatur +
				", sollTemperatur=" + sollTemperatur +
				", lights=" + lights +

				'}';
	}
}   