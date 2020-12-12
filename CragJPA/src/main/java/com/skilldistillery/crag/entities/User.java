package com.skilldistillery.crag.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String username;

	@Column(name = "favorite_beer")
	private String favoriteBeer;

	@Column(name = "has_dog")
	private boolean hasDog;

	@Column(name = "profile_pic")
	private String profilePic;

	@Column(name = "climbing_since")
	private int climbingSince;

	private String goals;

	private String availability;
	
	private String role;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "other_hobbies")
	private String otherHobbies;

	private LocalDate birthdate;

	private String password;

	@JsonIgnoreProperties({"userList", "climbTypes"})
	@ManyToMany
	@JoinTable(name="user_climb_type", 
	joinColumns = @JoinColumn(name="user_id"), 
	inverseJoinColumns = @JoinColumn(name = "climb_type_id"))
	private List<ClimbType> climbTypes;

	
	@JsonIgnoreProperties({"users", "events"})
	@ManyToMany
	@JoinTable(name="favorite_area", 
	joinColumns = @JoinColumn(name="user_id"), 
	inverseJoinColumns = @JoinColumn(name = "climbing_area_id"))
	private List<ClimbingArea> favoriteAreaList;
	
	
	@JsonIgnoreProperties({"users"})
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@JsonIgnoreProperties({"users"})
	@OneToMany(mappedBy = "createdBy")
	List<Event> createdEvents;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="user_has_event", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> attendedEvents;

	
	@OneToMany(mappedBy = "user")
	List<Gear> gearList;
	
	@JsonIgnoreProperties({"myListOfFavoriteUsers", "listOfUsersWhoHaveFavoritedMe", "createdEvents", "myListOfReceivedMessages", "myListOfSentMessages"})
	@ManyToMany
	@JoinTable(name = "favorite_user", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "favorite_user_id"))
	private List<User> myListOfFavoriteUsers;
	
	
	@JsonIgnoreProperties({"myListOfFavoriteUsers", "listOfUsersWhoHaveFavoritedMe", "createdEvents", "myListOfReceivedMessages", "myListOfSentMessages"})
	@ManyToMany(mappedBy = "myListOfFavoriteUsers")
	private List<User> listOfUsersWhoHaveFavoritedMe;
	
	
	@OneToMany(mappedBy = "user")
	List<Media> mediaList;
	
	
	
//	@JoinTable(name = "message", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name = "receiver_id"))
	@OneToMany(mappedBy = "receiver")
	private List<Message> myListOfReceivedMessages;
	
	
	
//	@JoinTable(name = "message", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name = "sender_id"))
	@OneToMany(mappedBy = "sender")
	private List<Message> myListOfSentMessages;
	
	private Boolean enabled;
	
	@JsonIgnoreProperties({"user"})
	@OneToMany(mappedBy = "user")
	private List<UserClimbType> userClimbTypes;
	
//	CONSTRUCTOR
	public User() {
		super();
	}

//	GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFavoriteBeer() {
		return favoriteBeer;
	}

	public void setFavoriteBeer(String favoriteBeer) {
		this.favoriteBeer = favoriteBeer;
	}

	public boolean isHasDog() {
		return hasDog;
	}

	public void setHasDog(boolean hasDog) {
		this.hasDog = hasDog;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public int getClimbingSince() {
		return climbingSince;
	}

	public void setClimbingSince(int climbingSince) {
		this.climbingSince = climbingSince;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getOtherHobbies() {
		return otherHobbies;
	}

	public void setOtherHobbies(String otherHobbies) {
		this.otherHobbies = otherHobbies;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public List<ClimbType> getClimbTypes() {
		return climbTypes;
	}

	public void setClimbTypes(List<ClimbType> climbTypes) {
		this.climbTypes = climbTypes;
	}

	public List<ClimbingArea> getFavoriteAreaList() {
		return favoriteAreaList;
	}

	public void setFavoriteAreaList(List<ClimbingArea> favoriteAreaList) {
		this.favoriteAreaList = favoriteAreaList;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Event> getCreatedEvents() {
		return createdEvents;
	}

	public void setCreatedEvents(List<Event> createdEvents) {
		this.createdEvents = createdEvents;
	}

	public List<Event> getAttendedEvents() {
		return attendedEvents;
	}

	public void setAttendedEvents(List<Event> attendedEvents) {
		this.attendedEvents = attendedEvents;
	}

	public List<Gear> getGearList() {
		return gearList;
	}

	public void setGearList(List<Gear> gearList) {
		this.gearList = gearList;
	}

	public List<User> getMyListOfFavoriteUsers() {
		return myListOfFavoriteUsers;
	}

	public void setMyListOfFavoriteUsers(List<User> myListOfFavoriteUsers) {
		this.myListOfFavoriteUsers = myListOfFavoriteUsers;
	}

	public List<User> getListOfUsersWhoHaveFavoritedMe() {
		return listOfUsersWhoHaveFavoritedMe;
	}

	public void setListOfUsersWhoHaveFavoritedMe(List<User> listOfUsersWhoHaveFavoritedMe) {
		this.listOfUsersWhoHaveFavoritedMe = listOfUsersWhoHaveFavoritedMe;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Media> getMediaList() {
		return mediaList;
	}
	
	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	
	
	public List<Message> getMyListOfReceivedMessages() {
		return myListOfReceivedMessages;
	}

	public void setMyListOfReceivedMessages(List<Message> myListOfReceivedMessages) {
		this.myListOfReceivedMessages = myListOfReceivedMessages;
	}

	public List<Message> getMyListOfSentMessages() {
		return myListOfSentMessages;
	}

	public void setMyListOfSentMessages(List<Message> myListOfSentMessages) {
		this.myListOfSentMessages = myListOfSentMessages;
	}

	//Add/Remove Methods
	public void addClimbType(ClimbType climbType) {
		if (climbTypes == null) {
			climbTypes = new ArrayList<>();
		}
		if (!climbTypes.contains(climbType)) {
			climbTypes.add(climbType);
			climbType.addUser(this);
		}
	}

	public void removeClimbType(ClimbType climbType) {
		if (climbTypes != null && climbTypes.contains(climbType)) {
			climbTypes.remove(climbType);
			climbType.removeUser(this);
		}
	}
	
	public void addClimbingArea(ClimbingArea climbingArea) {
		if (favoriteAreaList == null) {
			favoriteAreaList = new ArrayList<>();
		}
		if (!favoriteAreaList.contains(climbingArea)) {
			favoriteAreaList.add(climbingArea);
			climbingArea.addUser(this);
		}
	}
	
	public void removeClimbingArea(ClimbingArea climbingArea) {
		if (favoriteAreaList != null && favoriteAreaList.contains(climbingArea)) {
			favoriteAreaList.remove(climbingArea);
			climbingArea.removeUser(this);
		}
	}
	
	public void addEvent(Event event) {
		if (attendedEvents == null) {
			attendedEvents = new ArrayList<>();
		}
		if (!attendedEvents.contains(event)) {
			attendedEvents.add(event);
			event.addUser(this);
		}
	}
	
	public void removeEvent(Event event) {
		if (attendedEvents != null && attendedEvents.contains(event)) {
			attendedEvents.remove(event);
			event.removeUser(this);
		}
	}
	public void removeLocation(Location location) {
			location.removeUser(this);
	}

	public void addReceivedMessage(Message message) {
		if (myListOfReceivedMessages == null) {
			myListOfReceivedMessages = new ArrayList<>();
		}
		if (!myListOfReceivedMessages.contains(message)) {
			myListOfReceivedMessages.add(message);
		}	
	}
	
	public void addSentMessage(Message message) {
		if (myListOfSentMessages == null) {
			myListOfSentMessages = new ArrayList<>();
		}
		if (!myListOfSentMessages.contains(message)) {
			myListOfSentMessages.add(message);
		}	
	}
	
	public void removeReceivedMessage(Message message) {
		if (myListOfReceivedMessages != null && myListOfReceivedMessages.contains(message)) {
			myListOfReceivedMessages.remove(message);
		}
	}
	
	public void removeSentMessage(Message message) {
		if (myListOfSentMessages != null && myListOfSentMessages.contains(message)) {
			myListOfSentMessages.remove(message);
		}
	}

	public void addMyListOfFavoriteUsers(User user) {
		if (myListOfFavoriteUsers == null) {
			myListOfFavoriteUsers = new ArrayList<>();
		}
		if (!myListOfFavoriteUsers.contains(user)) {
			myListOfFavoriteUsers.add(user);
			user.addListOfUsersWhoHaveFavoritedMe(this);
		}
	}

	public void removeMyListOfFavoriteUsers(User user) {
		if (myListOfFavoriteUsers != null && myListOfFavoriteUsers.contains(user)) {
			myListOfFavoriteUsers.remove(user);
			user.removeListOfUsersWhoHaveFavoritedMe(this);
		}
	}
	
	public void addListOfUsersWhoHaveFavoritedMe(User user) {
		if (listOfUsersWhoHaveFavoritedMe == null) {
			listOfUsersWhoHaveFavoritedMe = new ArrayList<>();
		}
		if (!listOfUsersWhoHaveFavoritedMe.contains(user)) {
			listOfUsersWhoHaveFavoritedMe.add(user);
			user.addMyListOfFavoriteUsers(this);
		}
	}
	
	public void removeListOfUsersWhoHaveFavoritedMe(User user) {
		if (listOfUsersWhoHaveFavoritedMe != null && listOfUsersWhoHaveFavoritedMe.contains(user)) {
			listOfUsersWhoHaveFavoritedMe.remove(user);
			user.removeMyListOfFavoriteUsers(this);
		}
	}
	
	
//	TO STRING METHOD
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", favoriteBeer=" + favoriteBeer + ", hasDog=" + hasDog + ", profilePic=" + profilePic
				+ ", climbingSince=" + climbingSince + ", goals=" + goals + ", availability=" + availability + ", role="
				+ role + ", createdAt=" + createdAt + ", lastLogin=" + lastLogin + ", otherHobbies=" + otherHobbies
				+ ", birthdate=" + birthdate + ", password=" + password + ", climbTypes=" + climbTypes
				+ ", favoriteAreaList=" + favoriteAreaList + ", location=" + location + ", createdEvents="
				+ createdEvents + ", attendedEvents=" + attendedEvents + ", gearList=" + gearList
				+ ", myListOfFavoriteUsers=" + myListOfFavoriteUsers + ", listOfUsersWhoHaveFavoritedMe="
				+ listOfUsersWhoHaveFavoritedMe + ", enabled=" + enabled + "]";
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public List<UserClimbType> getUserClimbTypes() {
		return userClimbTypes;
	}

	public void setUserClimbTypes(List<UserClimbType> userClimbTypes) {
		this.userClimbTypes = userClimbTypes;
	}


}
