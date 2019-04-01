package javatech.hibernate.entity;

import java.util.List;

public class UserProfile {
	
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	/*public List<Long> getFriendsList() {
		return followingChannels;
	}
	public void setFriendsList(List<Long> friendsList) {
		this.followingChannels = friendsList;
	}*/
	
	private String dpName;
	private String dob;
	private String currentCity;
	private String homeTown;
//	private List<Long> followingChannels;
	
}