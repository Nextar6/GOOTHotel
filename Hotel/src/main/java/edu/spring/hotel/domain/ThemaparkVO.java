package edu.spring.hotel.domain;

import java.util.Date;

public class ThemaparkVO {
	private int themaparkNo;
	private String themaparkTitle;
	private String themaparkContent;
	private String themaparkPic;
	private String themaparkBookDate;
	private String memberUserid;
	private int themaparkPrice;
	private int themaparkLikeCount;
	private int themaparkReplyCount;
	private Date themaparkCdate;
	
	public ThemaparkVO() {}
	public ThemaparkVO(int themaparkNo, String themaparkTitle, String themaparkContent, String themaparkPic,
			String themaparkBookDate, String memberUserid, int themaparkPrice, int themaparkLikeCount,
			int themaparkReplyCount, Date themaparkCdate) {
		super();
		this.themaparkNo = themaparkNo;
		this.themaparkTitle = themaparkTitle;
		this.themaparkContent = themaparkContent;
		this.themaparkPic = themaparkPic;
		this.themaparkBookDate = themaparkBookDate;
		this.memberUserid = memberUserid;
		this.themaparkPrice = themaparkPrice;
		this.themaparkLikeCount = themaparkLikeCount;
		this.themaparkReplyCount = themaparkReplyCount;
		this.themaparkCdate = themaparkCdate;
	}
	public int getThemaparkNo() {
		return themaparkNo;
	}
	public void setThemaparkNo(int themaparkNo) {
		this.themaparkNo = themaparkNo;
	}
	public String getThemaparkTitle() {
		return themaparkTitle;
	}
	public void setThemaparkTitle(String themaparkTitle) {
		this.themaparkTitle = themaparkTitle;
	}
	public String getThemaparkContent() {
		return themaparkContent;
	}
	public void setThemaparkContent(String themaparkContent) {
		this.themaparkContent = themaparkContent;
	}
	public String getThemaparkPic() {
		return themaparkPic;
	}
	public void setThemaparkPic(String themaparkPic) {
		this.themaparkPic = themaparkPic;
	}
	public String getThemaparkBookDate() {
		return themaparkBookDate;
	}
	public void setThemaparkBookDate(String themaparkBookDate) {
		this.themaparkBookDate = themaparkBookDate;
	}
	public String getMemberUserid() {
		return memberUserid;
	}
	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}
	public int getThemaparkPrice() {
		return themaparkPrice;
	}
	public void setThemaparkPrice(int themaparkPrice) {
		this.themaparkPrice = themaparkPrice;
	}
	public int getThemaparkLikeCount() {
		return themaparkLikeCount;
	}
	public void setThemaparkLikeCount(int themaparkLikeCount) {
		this.themaparkLikeCount = themaparkLikeCount;
	}
	public int getThemaparkReplyCount() {
		return themaparkReplyCount;
	}
	public void setThemaparkReplyCount(int themaparkReplyCount) {
		this.themaparkReplyCount = themaparkReplyCount;
	}
	public Date getThemaparkCdate() {
		return themaparkCdate;
	}
	public void setThemaparkCdate(Date themaparkCdate) {
		this.themaparkCdate = themaparkCdate;
	}
	@Override
	public String toString() {
		return "ThemaparkVO [themaparkNo=" + themaparkNo + ", themaparkTitle=" + themaparkTitle + ", themaparkContent="
				+ themaparkContent + ", themaparkPic=" + themaparkPic + ", themaparkBookDate=" + themaparkBookDate
				+ ", memberUserid=" + memberUserid + ", themaparkPrice=" + themaparkPrice + ", themaparkLikeCount="
				+ themaparkLikeCount + ", themaparkReplyCount=" + themaparkReplyCount + ", themaparkCdate="
				+ themaparkCdate + "]";
	} 
	
	

} // end ThemaparkVO
