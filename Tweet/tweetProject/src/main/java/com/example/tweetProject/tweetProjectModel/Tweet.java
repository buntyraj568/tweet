package com.example.tweetProject.tweetProjectModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tweets")
public class Tweet {
	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private Date createdDate;
	private Date editedDate;

	public Tweet(){

	}
	
	public Tweet(Long id, String text, Date createdDate, Date editedDate) {
		super();
		this.id = id;
		this.text = text;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getEditedDate() {
		return editedDate;
	}
	public void setEditedDate(Date edited) {
		this.editedDate = editedDate;
	}

	@Override
	public String toString() {
		return "Tweet{" +
				"id=" + id +
				", text='" + text + '\'' +
				", createdDate='" + createdDate + '\'' +
				", editedDate='" + editedDate + '\'' +
				'}';
	}
}
