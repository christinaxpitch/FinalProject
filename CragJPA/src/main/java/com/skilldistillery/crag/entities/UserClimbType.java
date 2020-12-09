package com.skilldistillery.crag.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_climb_type")
public class UserClimbType {

	@EmbeddedId
	private UserClimbTypeId id;

	@Column(name = "recent_grade")
	private String recentGrade;

	@Column(name = "lead_climb")
	private boolean leadClimb;

	@ManyToOne
	@JoinColumn(name = "user_id") 
	@MapsId(value = "userId") 
	private User user;

	@ManyToOne
	@JoinColumn(name = "climb_type_id") 
	@MapsId(value = "climbTypeId") 
	private ClimbType climbType;

	
	public UserClimbType() {
		super();
	}

	public UserClimbType(UserClimbTypeId id, String recentGrade, boolean leadClimb) {
		super();
		this.id = id;
		this.recentGrade = recentGrade;
		this.leadClimb = leadClimb;
	}

	public UserClimbTypeId getId() {
		return id;
	}

	public void setId(UserClimbTypeId id) {
		this.id = id;
	}

	public String getRecentGrade() {
		return recentGrade;
	}

	public void setRecentGrade(String recentGrade) {
		this.recentGrade = recentGrade;
	}

	public boolean isLeadClimb() {
		return leadClimb;
	}

	public void setLeadClimb(boolean leadClimb) {
		this.leadClimb = leadClimb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserClimbType other = (UserClimbType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserClimbType [id=" + id + ", recentGrade=" + recentGrade + ", leadClimb=" + leadClimb + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ClimbType getClimbType() {
		return climbType;
	}

	public void setClimbType(ClimbType climbType) {
		this.climbType = climbType;
	}

}
