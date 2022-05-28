package edu.spring.hotel.domain;

public class ShopingCartVO {
	private int productNo;
	private String productCategory;
	private String productName;
	


	public ShopingCartVO(int productNo, String productCategory, String productName) {
		super();
		this.productNo = productNo;
		this.productCategory = productCategory;
		this.productName = productName;
	}



	public int getProductNo() {
		return productNo;
	}



	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}



	public String getProductCategory() {
		return productCategory;
	}



	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	@Override
	public String toString() {
		return "ShopingCartVO [productNo=" + productNo + ", productCategory=" + productCategory + ", productName="
				+ productName + "]";
	};
	
	
	

}
