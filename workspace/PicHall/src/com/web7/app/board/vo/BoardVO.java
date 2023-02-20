package com.web7.app.board.vo;

public class BoardVO {
	private int board_seq;
	private String board_title;
	private String board_text;
	private String board_date;
	private int board_hits;
	private int board_like;
	private int member_seq;
	private int board_category_id;

	public BoardVO() {;}
	
	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_text() {
		return board_text;
	}

	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public int getBoard_hits() {
		return board_hits;
	}

	public void setBoard_hits(int board_hits) {
		this.board_hits = board_hits;
	}

	public int getBoard_like() {
		return board_like;
	}

	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public int getBoard_category_id() {
		return board_category_id;
	}

	public void setBoard_category_id(int board_category_id) {
		this.board_category_id = board_category_id;
	}

}
