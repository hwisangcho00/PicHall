package com.web7.app.photo.vo;

public class PhotoVO {
	
	private int photo_seq;
	private String photo_data;
	private String photo_name;
	private String photo_text;
	private int member_seq;

	public PhotoVO() {;}
	
	public int getPhoto_seq() {
		return photo_seq;
	}
	public void setPhoto_seq(int photo_seq) {
		this.photo_seq = photo_seq;
	}
	public String getPhoto_data() {
		return photo_data;
	}
	
	public void setPhoto_data(String photo_data) {
		this.photo_data = photo_data;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPhoto_text() {
		return photo_text;
	}
	public void setPhoto_text(String photo_text) {
		this.photo_text = photo_text;
	}
	
	public int getMember_seq() {
		return member_seq;
	}
	
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
}
