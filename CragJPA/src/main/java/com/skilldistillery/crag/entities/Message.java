package com.skilldistillery.crag.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Message {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@JsonIgnoreProperties({"myListOfFavoriteUsers", "createdEvents", "listOfUsersWhoHaveFavoritedMe", "favoriteAreaList", "myListOfSentMessages", "myListOfReceivedMessages"})
	//@JsonIgnoreProperties({"myListOfReceivedMessages", "myListOfSentMessages", "createdEvents"})
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;
	
	@JsonIgnoreProperties({"myListOfFavoriteUsers", "createdEvents", "listOfUsersWhoHaveFavoritedMe", "favoriteAreaList", "myListOfReceivedMessages", "myListOfSentMessages"})
	//@JsonIgnoreProperties({"myListOfReceivedMessages", "myListOfSentMessages", "createdEvents"})
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User receiver;
	
	@Column(name="message_body")
	private String messageBody;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
	
	

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	
	
	

	public Message(int id, LocalDateTime createdAt, User sender, User receiver, String messageBody) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.sender = sender;
		this.receiver = receiver;
		this.messageBody = messageBody;
	}

	public Message() {
		super();
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
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", createdAt=" + createdAt + ", sender=" + sender + ", receiver=" + receiver
				+ ", messageBody=" + messageBody + "]";
	}
	
	
}
