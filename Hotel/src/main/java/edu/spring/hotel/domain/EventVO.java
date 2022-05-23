package edu.spring.hotel.domain;

import java.util.Date;

public class EventVO {
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String writer;
	Date eventCdate;
	
	public EventVO() {}
	
	public EventVO(int eventNo, String eventTitle, String eventContent, String writer, Date eventCdate) {
		super();
		this.eventNo = eventNo;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.writer = writer;
		this.eventCdate = eventCdate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getEventCdate() {
		return eventCdate;
	}

	public void setEventCdate(Date eventCdate) {
		this.eventCdate = eventCdate;
	}

	@Override
	public String toString() {
		return "EventVO [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
				+ ", writer=" + writer + ", eventCdate=" + eventCdate + "]";
	}
	
	

}
