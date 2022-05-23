package edu.spring.hotel.domain;

import java.util.Date;

public class FoodReviewVO {
	private int foodRvNo;
	private int foodRvLike;
	private String foodRvTitle;
	private String foodRvContent;
	private String memberUserid;
	private Date foodRvCdate;
	private int foodNo;
	
	public FoodReviewVO() {}

	public FoodReviewVO(int foodRvNo, int foodRvLike, String foodRvTitle, String foodRvContent, String memberUserid,
			Date foodRvCdate, int foodNo) {
		super();
		this.foodRvNo = foodRvNo;
		this.foodRvLike = foodRvLike;
		this.foodRvTitle = foodRvTitle;
		this.foodRvContent = foodRvContent;
		this.memberUserid = memberUserid;
		this.foodRvCdate = foodRvCdate;
		this.foodNo = foodNo;
	}

	public int getFoodRvNo() {
		return foodRvNo;
	}

	public void setFoodRvNo(int foodRvNo) {
		this.foodRvNo = foodRvNo;
	}

	public int getFoodRvLike() {
		return foodRvLike;
	}

	public void setFoodRvLike(int foodRvLike) {
		this.foodRvLike = foodRvLike;
	}

	public String getFoodRvTitle() {
		return foodRvTitle;
	}

	public void setFoodRvTitle(String foodRvTitle) {
		this.foodRvTitle = foodRvTitle;
	}

	public String getFoodRvContent() {
		return foodRvContent;
	}

	public void setFoodRvContent(String foodRvContent) {
		this.foodRvContent = foodRvContent;
	}

	public String getMemberUserid() {
		return memberUserid;
	}

	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}

	public Date getFoodRvCdate() {
		return foodRvCdate;
	}

	public void setFoodRvCdate(Date foodRvCdate) {
		this.foodRvCdate = foodRvCdate;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	@Override
	public String toString() {
		return "FoodReviewVO [foodRvNo=" + foodRvNo + ", foodRvLike=" + foodRvLike + ", foodRvTitle=" + foodRvTitle
				+ ", foodRvContent=" + foodRvContent + ", memberUserid=" + memberUserid + ", foodRvCdate=" + foodRvCdate
				+ ", foodNo=" + foodNo + "]";
	}
	
	

}
