package edu.spring.hotel.domain;

import java.util.Date;

public class InqueryVO {
	private int inqueryNo;
	private String inqueryTitle;
	private String inqueryContent;
	private String memberUserid;
	Date inqueryCdate;
	private String inqueryReplyCount;
	
	InqueryVO(){}
	
	public InqueryVO(int inqueryNo, String inqueryTitle, String inqueryContent, String memberUserid,
			Date inqueryCdate, String inqueryReplyCount) {
		super();
		this.inqueryNo = inqueryNo;
		this.inqueryTitle = inqueryTitle;
		this.inqueryContent = inqueryContent;
		this.memberUserid = memberUserid;
		this.inqueryCdate = inqueryCdate;
		this.inqueryReplyCount = inqueryReplyCount;
	}

	public String getInqueryReplyCount() {
		return inqueryReplyCount;
	}

	public void setInqueryReplyCount(String inqueryReplyCount) {
		this.inqueryReplyCount = inqueryReplyCount;
	}

	public int getInqueryNo() {
		return inqueryNo;
	}

	public void setInqueryNo(int inqueryNo) {
		this.inqueryNo = inqueryNo;
	}

	public String getInqueryTitle() {
		return inqueryTitle;
	}

	public void setInqueryTitle(String inqueryTitle) {
		this.inqueryTitle = inqueryTitle;
	}

	public String getInqueryContent() {
		return inqueryContent;
	}

	public void setInqueryContent(String inqueryContent) {
		this.inqueryContent = inqueryContent;
	}

	public String getMemberUserid() {
		return memberUserid;
	}

	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}

	public Date getInqueryCdate() {
		return inqueryCdate;
	}

	public void setInqueryCdate(Date inqueryCdate) {
		this.inqueryCdate = inqueryCdate;
	}

	@Override
	public String toString() {
		return "InqueryVO [inqueryNo=" + inqueryNo + ", inqueryTitle=" + inqueryTitle + ", inqueryContent="
				+ inqueryContent + ", memberUserid=" + memberUserid + ", inqueryCdate=" + inqueryCdate + ", inqueryReplyCount=" + inqueryReplyCount + "]";
	}
	
	

}
