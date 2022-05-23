package edu.spring.hotel.domain;

import java.util.Date;

public class AnounceVO {
	private int anounceNo;
	private String anounceTitle;
	private String anounceContent;
	private String writer;
	private Date anounceCdate;
	
	public AnounceVO() {}

	public AnounceVO(int anounceNo, String anounceTitle, String anounceContent, String writer,
			Date anounceCdate) {
		super();
		this.anounceNo = anounceNo;
		this.anounceTitle = anounceTitle;
		this.anounceContent = anounceContent;
		this.writer = writer;
		this.anounceCdate = anounceCdate;
	}

	public int getAnounceNo() {
		return anounceNo;
	}

	public void setAnounceNo(int anounceNo) {
		this.anounceNo = anounceNo;
	}

	public String getAnounceTitle() {
		return anounceTitle;
	}

	public void setAnounceTitle(String anounceTitle) {
		this.anounceTitle = anounceTitle;
	}

	public String getAnounceContent() {
		return anounceContent;
	}

	public void setAnounceContent(String anounceContent) {
		this.anounceContent = anounceContent;
	}

	public String getwriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getAnounceCdate() {
		return anounceCdate;
	}

	public void setAnounceCdate(Date anounceCdate) {
		this.anounceCdate = anounceCdate;
	}

	@Override
	public String toString() {
		return "AnounceVO [anounceNo=" + anounceNo + ", anounceTitle=" + anounceTitle + ", anounceContent="
				+ anounceContent + ", writer=" + writer + ", anounceCdate=" + anounceCdate + "]";
	}
	
	


}
