package com.web7.app.attach.vo;

public class AttachVO {
	private int attach_seq;
	private String attach_name;
	private int board_seq;

	public AttachVO() {;}
	
	public int getAttach_seq() {
		return attach_seq;
	}

	public void setAttach_seq(int attach_seq) {
		this.attach_seq = attach_seq;
	}

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

}
