package com.skilldistillery.crag.entities;

import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="event_name")
	private String eventName;
	
	private String description;
	
	@Column(name = "img_url")
	private String imgUrl;
	
//	@Column(name = "climbing_area_id")
//	private int climbingAreaId;
//	do not need this for foreign key
	
	@JsonIgnoreProperties({"users", "events"})
	@ManyToOne
	@JoinColumn(name = "climbing_area_id")
	private ClimbingArea climbingArea;
	//should be private ClimbingArea climbingArea;
	
	@Column(name = "event_date")
	private LocalDateTime eventDate;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@JsonIgnoreProperties({"favoriteAreaList", "createdEvents", "myListOfFavoriteUsers", "listOfUsersWhoHaveFavoritedMe", "mediaList", "climbTypes", "myListOfReceivedMessages", "myListOfSentMessages"})
	@ManyToOne
	@JoinColumn(name = "created_by_user_id")
	private User createdBy;
	
	
	@JsonIgnoreProperties({"favoriteAreaList", "createdEvents", "myListOfFavoriteUsers", "listOfUsersWhoHaveFavoritedMe", "mediaList", "climbTypes", "myListOfReceivedMessages", "myListOfSentMessages"})
	@ManyToMany(mappedBy = "attendedEvents")
	private List<User> attendedUsers;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	

	public Event(int id, String eventName, String description, String imgUrl, ClimbingArea climbingArea,
			LocalDateTime eventDate, LocalDateTime createdAt, User createdBy, List<User> attendedUsers) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.description = description;
		this.imgUrl = imgUrl;
		this.climbingArea = climbingArea;
		this.eventDate = eventDate;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.attendedUsers = attendedUsers;
	}

	public ClimbingArea getClimbingArea() {
		return climbingArea;
	}

	public void setClimbingArea(ClimbingArea climbingArea) {
		this.climbingArea = climbingArea;
	}

	public List<User> getAttendedUsers() {
		return attendedUsers;
	}

	public void setAttendedUsers(List<User> attendedUsers) {
		this.attendedUsers = attendedUsers;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", description=" + description + ", imgUrl=" + imgUrl
				+ ", climbingArea=" + climbingArea + ", eventDate=" + eventDate + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", attendedUsers=" + attendedUsers + "]";
	}

	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	public Event() {
		super();
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	
	public void addUser(User user) {
		if (attendedUsers == null) {
			attendedUsers = new ArrayList<>();
		}
		if (!attendedUsers.contains(user)) {
			attendedUsers.add(user);
			if (user.getFavoriteAreaList() != null) {
				user.addEvent(this);
			}
		}
	}
	
	public void removeUser(User user) {
		if (attendedUsers != null && attendedUsers.contains(user)) {
			attendedUsers.remove(user);
			user.removeEvent(this);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
