package edu.spring.hotel.domain;

import java.util.Date;

public class QuestionVO {
	private int questionNo;
	private String questionTitle;
	private String questionContent;
	private String writer;
	Date questionCdate;

	public QuestionVO() {}

	public QuestionVO(int questionNo, String questionTitle, String questionContent, String writer, Date questionCdate) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.writer = writer;
		this.questionCdate = questionCdate;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getQuestionCdate() {
		return questionCdate;
	}

	public void setQuestionCdate(Date questionCdate) {
		this.questionCdate = questionCdate;
	}

	@Override
	public String toString() {
		return "QuestionVO [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", writer=" + writer + ", questionCdate=" + questionCdate + "]";
	}
	
	
}
