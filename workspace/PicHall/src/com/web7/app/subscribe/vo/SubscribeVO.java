package com.web7.app.subscribe.vo;

public class SubscribeVO {
	//내가 팔로잉한 사람
	private int following_id;
	//나를 팔로잉한 사람
	private int followed_id;
	
	public SubscribeVO() {;}
	
	public int getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(int following_id) {
		this.following_id = following_id;
	}
	public int getFollowed_id() {
		return followed_id;
	}
	public void setFollowed_id(int followed_id) {
		this.followed_id = followed_id;
	}
}
