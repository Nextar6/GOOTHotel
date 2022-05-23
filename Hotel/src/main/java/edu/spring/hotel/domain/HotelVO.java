package edu.spring.hotel.domain;

public class HotelVO {
	int hotelNo;
	String hotelTitle;
	int hotelPricePeople;
	int hotelPriceNight;
	String hotelContent;
	int hotelGrade;
	String hotelAddress;
	String hotelPackage;
	String hotelPic;

	public HotelVO() {}
	
	// TODO Hotel price 처리 1개 통합

	public HotelVO(int hotelNo, String hotelTitle, int hotelPricePeople, int hotelPriceNight, String hotelContent,
			int hotelGrade, String hotelAddress, String hotelPackage, String hotelPic) {
		this.hotelNo = hotelNo;
		this.hotelTitle = hotelTitle;
		this.hotelPricePeople = hotelPricePeople;
		this.hotelPriceNight = hotelPriceNight;
		this.hotelContent = hotelContent;
		this.hotelGrade = hotelGrade;
		this.hotelAddress = hotelAddress;
		this.hotelPackage = hotelPackage;
		this.hotelPic = hotelPic;
	}

	public int getHotelPriceNight() {
		return hotelPriceNight;
	}

	public void setHotelPriceNight(int hotelPriceNight) {
		this.hotelPriceNight = hotelPriceNight;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getHotelTitle() {
		return hotelTitle;
	}

	public void setHotelTitle(String hotelTitle) {
		this.hotelTitle = hotelTitle;
	}

	public int getHotelPricePeople() {
		return hotelPricePeople;
	}

	public void setHotelPricePeople(int hotelPricePeople) {
		this.hotelPricePeople = hotelPricePeople;
	}


	public String getHotelContent() {
		return hotelContent;
	}

	public void setHotelContent(String hotelContent) {
		this.hotelContent = hotelContent;
	}

	public int getHotelGrade() {
		return hotelGrade;
	}

	public void setHotelGrade(int hotelGrade) {
		this.hotelGrade = hotelGrade;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelPackage() {
		return hotelPackage;
	}

	public void setHotelPackage(String hotelPackage) {
		this.hotelPackage = hotelPackage;
	}

	public String getHotelPic() {
		return hotelPic;
	}

	public void setHotelPic(String hotelPic) {
		this.hotelPic = hotelPic;
	}

	@Override
	public String toString() {
		return "HotelVO [hotelNo=" + hotelNo + ", hotelTitle=" + hotelTitle + ", hotelPriceNight=" + hotelPriceNight
				+ ", hotelPricePeople=" + hotelPricePeople + ", hotelContent=" + hotelContent + ", hotelGrade="
				+ hotelGrade + ", hotelAddress=" + hotelAddress + ", hotelPackage=" + hotelPackage + ", hotelPic="
				+ hotelPic + "]";
	}
}
