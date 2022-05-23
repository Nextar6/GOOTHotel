package edu.spring.hotel.domain;

import java.util.Date;

public class PlayReviewVO {
	private int playRvNo;
	private int playRvLike;
	private String playRvTitle;
	private String playRvContent;
	private String memberUserid;
	Date playRvCdate;
	private int playNo;

	public PlayReviewVO() {
	}

	public PlayReviewVO(int playRvNo, int playRvLike, String playRvTitle, String playRvContent, String memberUserid,
			Date playRvCdate, int playNo) {
		super();
		this.playRvNo = playRvNo;
		this.playRvLike = playRvLike;
		this.playRvTitle = playRvTitle;
		this.playRvContent = playRvContent;
		this.memberUserid = memberUserid;
		this.playRvCdate = playRvCdate;
		this.playNo = playNo;
	}

	public int getPlayRvNo() {
		return playRvNo;
	}

	public void setPlayRvNo(int playRvNo) {
		this.playRvNo = playRvNo;
	}

	public int getPlayRvLike() {
		return playRvLike;
	}

	public void setPlayRvLike(int playRvLike) {
		this.playRvLike = playRvLike;
	}

	public String getPlayRvTitle() {
		return playRvTitle;
	}

	public void setPlayRvTitle(String playRvTitle) {
		this.playRvTitle = playRvTitle;
	}

	public String getPlayRvContent() {
		return playRvContent;
	}

	public void setPlayRvContent(String playRvContent) {
		this.playRvContent = playRvContent;
	}

	public String getMemberUserid() {
		return memberUserid;
	}

	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}

	public Date getPlayRvCdate() {
		return playRvCdate;
	}

	public void setPlayRvCdate(Date playRvCdate) {
		this.playRvCdate = playRvCdate;
	}

	public int getPlayNo() {
		return playNo;
	}

	public void setPlayNo(int playNo) {
		this.playNo = playNo;
	}

	@Override
	public String toString() {
		return "PlayReviewVO [playRvNo=" + playRvNo + ", playRvLike=" + playRvLike + ", playRvTitle=" + playRvTitle
				+ ", playRvContent=" + playRvContent + ", memberUserid=" + memberUserid + ", playRvCdate=" + playRvCdate
				+ ", playNo=" + playNo + "]";
	}
		
	
	
} // end PlayReviewVO
