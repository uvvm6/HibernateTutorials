package javatech.hibernate.entity;

import java.util.List;

public class Channels {

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getRating() {
		return Rating;
	}
	public void setRating(long rating) {
		Rating = rating;
	}
	
	private long id;
	private String name;
	private String description;
	private long Rating;
//	private List<Long> followersId;

}
