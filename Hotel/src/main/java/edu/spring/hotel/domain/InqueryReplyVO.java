package edu.spring.hotel.domain;

import java.util.Date;

public class InqueryReplyVO {
	private int inqueryRpNo;
	private int inqueryNo;
	private String inqueryRpContent;
	private String memberUserid;
	Date inqueryRpCdate;
	
	public InqueryReplyVO() {}

	public InqueryReplyVO(int inqueryRpNo, int inqueryNo, String inqueryRpContent, String memberUserid, Date inqueryRpCdate) {
		super();
		this.inqueryRpNo = inqueryRpNo;
		this.inqueryNo = inqueryNo;
		this.inqueryRpContent = inqueryRpContent;
		this.memberUserid = memberUserid;
		this.inqueryRpCdate = inqueryRpCdate;
	}

	public int getInqueryRpNo() {
		return inqueryRpNo;
	}

	public void setInqueryRpNo(int inqueryRpNo) {
		this.inqueryRpNo = inqueryRpNo;
	}

	public int getInqueryNo() {
		return inqueryNo;
	}

	public void setInqueryNo(int inqueryNo) {
		this.inqueryNo = inqueryNo;
	}

	public String getInqueryRpContent() {
		return inqueryRpContent;
	}

	public void setInqueryRpContent(String inqueryRpContent) {
		this.inqueryRpContent = inqueryRpContent;
	}

	public String getMemberUserid() {
		return memberUserid;
	}

	public void setMmemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}

	public Date getInqueryRpCdate() {
		return inqueryRpCdate;
	}

	public void setInqueryRpCdate(Date inqueryRpCdate) {
		this.inqueryRpCdate = inqueryRpCdate;
	}

	@Override
	public String toString() {
		return "InqueryReplyVO [inqueryRpNo=" + inqueryRpNo + ", inqueryNo=" + inqueryNo + ", inqueryRpContent="
				+ inqueryRpContent + ", memberUserid=" + memberUserid + ", inqueryRpCdate=" + inqueryRpCdate + "]";
	}
	
	

} // end inqueryReplyVO
