package edu.spring.hotel.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PlayVO {
	private int playNo;
	private String playTitle;
	private String playContent;
	private String playPic;
	private String playBookDate;
	private int playReplyCount;
	private Date playCdate;
	private String memberUserid;
	private String playPrice;
	private int playLikeCount;



	public PlayVO() {}


	public PlayVO(int playNo, String playTitle, String playContent, String playPic, String playBookDate,
			 int playReplyCount, int playLikeCount, Date playCdate, String memberUserid, String playPrice) {
		super();
		this.playNo = playNo;
		this.playTitle = playTitle;
		this.playContent = playContent;
		this.playPic = playPic;
		this.playBookDate = playBookDate;
		this.playReplyCount = playReplyCount;
		this.playLikeCount = playLikeCount;
		this.playCdate = playCdate;
		this.memberUserid = memberUserid;
		this.playPrice = playPrice;
	
	}


	public int getPlayLikeCount() {
		return playLikeCount;
	}


	public void setPlayLikeCount(int playLikeCount) {
		this.playLikeCount = playLikeCount;
	}


	public int getPlayNo() {
		return playNo;
	}


	public void setPlayNo(int playNo) {
		this.playNo = playNo;
	}


	public String getPlayTitle() {
		return playTitle;
	}


	public void setPlayTitle(String playTitle) {
		this.playTitle = playTitle;
	}


	public String getPlayContent() {
		return playContent;
	}


	public void setPlayContent(String playContent) {
		this.playContent = playContent;
	}


	public String getPlayPic() {
		return playPic;
	}


	public void setPlayPic(String playPic) {
		this.playPic = playPic;
	}


	public String getPlayBookDate() {
		return playBookDate;
	}


	public void setPlayBookDate(String playBookDate) {
		this.playBookDate = playBookDate;
	}



	public int getPlayReplyCount() {
		return playReplyCount;
	}


	public void setPlayReplyCount(int playReplyCount) {
		this.playReplyCount = playReplyCount;
	}


	public Date getPlayCdate() {
		return playCdate;
	}


	public void setPlayCdate(Date playCdate) {
		this.playCdate = playCdate;
	}


	public String getMemberUserid() {
		return memberUserid;
	}


	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}


	public String getPlayPrice() {
		return playPrice;
	}


	public void setPlayPrice(String playPrice) {
		this.playPrice = playPrice;
	}


	@Override
	public String toString() {
		return "PlayVO [playNo=" + playNo + ", playTitle=" + playTitle + ", playContent=" + playContent + ", playPic="
				+ playPic + ", playBookDate=" + playBookDate + ", playLikeCount=" + playLikeCount
				+ ", playReplyCount=" + playReplyCount + ", playCdate=" + playCdate + ", memberUserid=" + memberUserid + ", price=" + playPrice + "]";
	}
	
	
	
	
	
}
