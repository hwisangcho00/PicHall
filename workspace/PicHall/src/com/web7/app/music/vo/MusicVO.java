package com.web7.app.music.vo;

public class MusicVO {
	private int music_seq;
	private String music_title;
	private String music_artist;
	private String music_data;
	private int member_seq;

	public MusicVO() {
		;
	}

	public String getMusic_artist() {
		return music_artist;
	}

	public void setMusic_artist(String music_artist) {
		this.music_artist = music_artist;
	}

	public int getMusic_seq() {
		return music_seq;
	}

	public void setMusic_seq(int music_seq) {
		this.music_seq = music_seq;
	}

	public String getMusic_title() {
		return music_title;
	}

	public void setMusic_title(String music_title) {
		this.music_title = music_title;
	}

	public String getMusic_data() {
		return music_data;
	}

	public void setMusic_data(String music_data) {
		this.music_data = music_data;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

}
