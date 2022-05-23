package edu.spring.hotel.domain;

import java.util.Date;

public class FoodVO {
	private int foodNo;
	private String foodTitle;
	private String foodContent;
	private String foodPic;
	private String foodBookDate;
	private String memberUserid;
	private int foodPrice;
	private int foodLikeCount;
	private int foodReplyCount;
	private Date foodCdate;

	public FoodVO() {}

	public FoodVO(int foodNo, String foodTitle, String foodContent, String foodPic, String foodBookDate,
			String memberUserid, int foodPrice, int foodLikeCount, int foodReplyCount, Date foodCdate) {
		super();
		this.foodNo = foodNo;
		this.foodTitle = foodTitle;
		this.foodContent = foodContent;
		this.foodPic = foodPic;
		this.foodBookDate = foodBookDate;
		this.memberUserid = memberUserid;
		this.foodPrice = foodPrice;
		this.foodLikeCount = foodLikeCount;
		this.foodReplyCount = foodReplyCount;
		this.foodCdate = foodCdate;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodTitle() {
		return foodTitle;
	}

	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}

	public String getFoodContent() {
		return foodContent;
	}

	public void setFoodContent(String foodContent) {
		this.foodContent = foodContent;
	}

	public String getFoodPic() {
		return foodPic;
	}

	public void setFoodPic(String foodPic) {
		this.foodPic = foodPic;
	}

	public String getFoodBookDate() {
		return foodBookDate;
	}

	public void setFoodBookDate(String foodBookDate) {
		this.foodBookDate = foodBookDate;
	}

	public String getMemberUserid() {
		return memberUserid;
	}

	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodLikeCount() {
		return foodLikeCount;
	}

	public void setFoodLikeCount(int foodLikeCount) {
		this.foodLikeCount = foodLikeCount;
	}

	public int getFoodReplyCount() {
		return foodReplyCount;
	}

	public void setFoodReplyCount(int foodReplyCount) {
		this.foodReplyCount = foodReplyCount;
	}

	public Date getFoodCdate() {
		return foodCdate;
	}

	public void setFoodCdate(Date foodCdate) {
		this.foodCdate = foodCdate;
	}

	@Override
	public String toString() {
		return "FoodVO [foodNo=" + foodNo + ", foodTitle=" + foodTitle + ", foodContent=" + foodContent + ", foodPic="
				+ foodPic + ", foodBookDate=" + foodBookDate + ", memberUserid=" + memberUserid + ", foodPrice="
				+ foodPrice + ", foodLikeCount=" + foodLikeCount + ", foodReplyCount=" + foodReplyCount + ", foodCdate="
				+ foodCdate + "]";
	}
	
	
}
