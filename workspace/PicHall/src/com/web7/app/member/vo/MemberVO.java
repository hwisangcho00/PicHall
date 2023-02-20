package com.web7.app.member.vo;

public class MemberVO {

	private int member_seq;
	private String member_name;
	private String member_id;
	private String member_pw;
	private String member_nickname;
	private String member_text;
	private String member_email;
	private String member_profile_pic;
	private int member_email_checked;
	private String member_email_hash;

	public MemberVO() {
		;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getMember_text() {
		return member_text;
	}

	public void setMember_text(String member_text) {
		this.member_text = member_text;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_profile_pic() {
		return member_profile_pic;
	}

	public void setMember_profile_pic(String member_profile_pic) {
		this.member_profile_pic = member_profile_pic;
	}

	public int getMember_email_checked() {
		return member_email_checked;
	}

	public void setMember_email_checked(int member_email_checked) {
		this.member_email_checked = member_email_checked;
	}

	public String getMember_email_hash() {
		return member_email_hash;
	}

	public void setMember_email_hash(String member_email_hash) {
		this.member_email_hash = member_email_hash;
	}

}
