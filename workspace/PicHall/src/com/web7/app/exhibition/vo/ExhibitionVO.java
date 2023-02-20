package com.web7.app.exhibition.vo;

public class ExhibitionVO {
	private int exhibition_seq;
	private int member_seq;
	private String exhibition_name;
	private String exhibition_text;
	private String start_date;
	private String end_date;
	private int parent_category_id;
	private int category_id;
	private int report_cnt;
	private int exhibition_status;
	private int like_cnt;
	private String main_photo_data;
	
	public String getMain_photo_data() {
		return main_photo_data;
	}

	public void setMain_photo_data(String main_photo_data) {
		this.main_photo_data = main_photo_data;
	}

	public ExhibitionVO() {;}
	
	public int getExhibition_seq() {
		return exhibition_seq;
	}
	public void setExhibition_seq(int exhibition_seq) {
		this.exhibition_seq = exhibition_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public String getExhibition_name() {
		return exhibition_name;
	}
	public void setExhibition_name(String exhibition_name) {
		this.exhibition_name = exhibition_name;
	}
	public String getExhibition_text() {
		return exhibition_text;
	}
	public void setExhibition_text(String exhibition_text) {
		this.exhibition_text = exhibition_text;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getReport_cnt() {
		return report_cnt;
	}
	public void setReport_cnt(int report_cnt) {
		this.report_cnt = report_cnt;
	}
	public int getExhibition_status() {
		return exhibition_status;
	}
	public void setExhibition_status(int exhibition_status) {
		this.exhibition_status = exhibition_status;
	}

	public int getParent_category_id() {
		return parent_category_id;
	}

	public void setParent_category_id(int parent_category_id) {
		this.parent_category_id = parent_category_id;
	}
	
	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	
}
