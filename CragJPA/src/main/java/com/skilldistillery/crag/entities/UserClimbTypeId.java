package com.skilldistillery.crag.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserClimbTypeId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "climb_type_id")
	private int climbTypeId;

	
	
	
	public UserClimbTypeId() {
		super();
	}

	public UserClimbTypeId(int userId, int climbTypeId) {
		super();
		this.userId = userId;
		this.climbTypeId = climbTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClimbTypeId() {
		return climbTypeId;
	}

	public void setClimbTypeId(int climbTypeId) {
		this.climbTypeId = climbTypeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserClimbTypeId [userId=" + userId + ", climbTypeId=" + climbTypeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + climbTypeId;
		result = prime * result + userId;
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
		UserClimbTypeId other = (UserClimbTypeId) obj;
		if (climbTypeId != other.climbTypeId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
