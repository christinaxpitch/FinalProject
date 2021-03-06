package com.skilldistillery.crag.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="climb_type")
public class ClimbType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name = "img_url")
	private String imgUrl;

	
	@JsonIgnore
	@ManyToMany(mappedBy = "climbTypes")
	private List<User> userList;
	
	
	@OneToMany(mappedBy = "climbType")
	private List<UserClimbType> climbTypes;
	
	
	public ClimbType() {
		super();
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
		ClimbType other = (ClimbType) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClimbType [id=" + id + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl + "]";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void addUser(User user) {
		if (userList == null) {
			userList = new ArrayList<>();
		}
		if (!userList.contains(user)) {
			userList.add(user);
			if (user.getFavoriteAreaList() != null) {
				user.addClimbType(this);
			}
		}
	}
	
	public void removeUser(User user) {
		if (userList != null && userList.contains(user)) {
			userList.remove(user);
			user.removeClimbType(this);
		}
	}
	
}
