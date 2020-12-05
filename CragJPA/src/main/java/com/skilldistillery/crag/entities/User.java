package com.skilldistillery.crag.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String favortieBeer;

	@Column(name = "has_dog")
	private boolean hasDog;

	@Column(name = "profile_pic")
	private String profilePic;

	@Column(name = "climbing_since")
	private int climbingSince;

	private String goals;

	private String availability;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "other_hobbies")
	private String otherHobbies;

	private LocalDate birthdate;

	private String password;

	
//	@Column(name = "recent_grade")
//	private String recentGrade;

//	CONSTRUCTOR
	public User() {
		super();
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

	public String getFavortieBeer() {
		return favortieBeer;
	}

	public void setFavortieBeer(String favortieBeer) {
		this.favortieBeer = favortieBeer;
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

//	public String getReentGrade() {
//		return reentGrade;
//	}
//
//	public void setReentGrade(String reentGrade) {
//		this.reentGrade = reentGrade;
//	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", favortieBeer=" + favortieBeer + ", hasDog=" + hasDog + ", profilePic=" + profilePic
				+ ", climbingSince=" + climbingSince + ", goals=" + goals + ", availability=" + availability
				+ ", createdAt=" + createdAt + ", lastLogin=" + lastLogin + ", otherHobbies=" + otherHobbies
				+ ", birthdate=" + birthdate + ", password=" + password + ", reentGrade=";
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

}
