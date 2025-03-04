package cts.rms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Restaurent {
	@Id
	private int id;
	private String name;
	private String location;
	private String type;	
	public Restaurent() {
		// TODO Auto-generated constructor stub
	}
	public Restaurent(int id, String name, String location, String type) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Restaurent [id=" + id + ", name=" + name + ", location=" + location + ", type=" + type + "]";
	}
	

}
