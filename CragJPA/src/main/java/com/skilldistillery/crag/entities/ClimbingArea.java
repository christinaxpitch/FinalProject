package com.skilldistillery.crag.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="climbing_area")
public class ClimbingArea {
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@JsonIgnoreProperties({"favoriteAreaList", "createdEvents", "attendedEvents", "gearList", "mediaList"})
	@ManyToMany(mappedBy="favoriteAreaList")
	private List<User> users;
	
	@JsonIgnoreProperties({"users"})
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
//	list of events
	@JsonIgnoreProperties({"climbingArea"})
	@OneToMany(mappedBy="climbingArea")
	private List<Event> events;
	
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	//Constructor
	public ClimbingArea() {
		super();
	}

	//Getters/Setters
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClimbingArea other = (ClimbingArea) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClimbingArea [id=" + id + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl
				+ "]";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> Users) {
		this.users = Users;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<>();
		}
		if (!users.contains(user)) {
			users.add(user);
			if (user.getFavoriteAreaList() != null) {
				user.addClimbingArea(this);
			}
		}
	}
	
	public void removeUser(User user) {
		if (users != null && users.contains(user)) {
			users.remove(user);
			user.removeClimbingArea(this);
		}
	}	
	
}
