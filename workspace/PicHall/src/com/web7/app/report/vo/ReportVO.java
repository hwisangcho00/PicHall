package com.web7.app.report.vo;

public class ReportVO {
	private int exhibition_seq;
	private int report_seq;
	private String report_title;
	private String report_text;
	
	public ReportVO() {;}

	public int getExhibition_seq() {
		return exhibition_seq;
	}

	public void setExhibition_seq(int exhibition_seq) {
		this.exhibition_seq = exhibition_seq;
	}

	public int getReport_seq() {
		return report_seq;
	}

	public void setReport_seq(int report_seq) {
		this.report_seq = report_seq;
	}

	public String getReport_title() {
		return report_title;
	}

	public void setReport_title(String report_title) {
		this.report_title = report_title;
	}

	public String getReport_text() {
		return report_text;
	}

	public void setReport_text(String report_text) {
		this.report_text = report_text;
	}
}
