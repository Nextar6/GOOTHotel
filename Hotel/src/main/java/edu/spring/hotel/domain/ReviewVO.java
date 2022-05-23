package edu.spring.hotel.domain;

import java.util.Date;

public class ReviewVO {
	int reviewNo;
	int hotelNo;
	String reviewWriter;
	String reviewContent;
	int reviewGrade;
	Date reviewCdate;
	String reviewPic;
	String hotelTitle;
	
	public ReviewVO() {}

	public ReviewVO(int reviewNo, int hotelNo, String reviewWriter, String reviewContent, int reviewGrade,
			Date reviewCdate, String reviewPic, String hotelTitle) {
		this.reviewNo = reviewNo;
		this.hotelNo = hotelNo;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.reviewGrade = reviewGrade;
		this.reviewCdate = reviewCdate;
		this.reviewPic = reviewPic;
		this.hotelTitle = hotelTitle;
	}

	public String getHotelTitle() {
		return hotelTitle;
	}

	public void setHotelTitle(String hotelTitle) {
		this.hotelTitle = hotelTitle;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public String getReviewPic() {
		return reviewPic;
	}

	public void setReviewPic(String reviewPic) {
		this.reviewPic = reviewPic;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public Date getReviewCdate() {
		return reviewCdate;
	}

	public void setReviewCdate(Date reviewCdate) {
		this.reviewCdate = reviewCdate;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", hotelNo=" + hotelNo + ", reviewWriter=" + reviewWriter
				+ ", reviewContent=" + reviewContent + ", reviewGrade=" + reviewGrade + ", reviewCdate=" + reviewCdate
				+ ", reviewPic=" + reviewPic + ", hotelTitle=" + hotelTitle + "]";
	}
}
