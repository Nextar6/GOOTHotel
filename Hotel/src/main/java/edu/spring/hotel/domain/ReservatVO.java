package edu.spring.hotel.domain;

import java.util.Date;

public class ReservatVO {
	int reservatNo;
	int hotelNo;
	int reservatNight;
	int reservatPrice;
	String reservatUserid;
	String hotelTitle;
	int reservatPeople;
	String checkIn;
	String checkOut;
	Date reservatCdate;

	public ReservatVO() {}

	public ReservatVO(int reservatNo, int hotelNo, String hotelTitle, int reservatNight, int reservatPrice, String reservatUserid,
			int reservatPeople, String checkIn, String checkOut, Date reservatCdate) {
		this.reservatNo = reservatNo;
		this.hotelNo = hotelNo;
		this.hotelTitle = hotelTitle;
		this.reservatNight = reservatNight;
		this.reservatPrice = reservatPrice;
		this.reservatUserid = reservatUserid;
		this.reservatPeople = reservatPeople;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservatCdate = reservatCdate;
	}

	public int getReservatNo() {
		return reservatNo;
	}

	public void setReservatNo(int reservatNo) {
		this.reservatNo = reservatNo;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public String getHotelTitle() {
		return hotelTitle;
	}

	public void setHotelTitle(String hotelTitle) {
		this.hotelTitle = hotelTitle;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public int getReservatNight() {
		return reservatNight;
	}

	public void setReservatNight(int reservatNight) {
		this.reservatNight = reservatNight;
	}

	public int getReservatPrice() {
		return reservatPrice;
	}

	public void setReservatPrice(int reservatPrice) {
		this.reservatPrice = reservatPrice;
	}

	public String getReservatUserid() {
		return reservatUserid;
	}

	public void setReservatUserid(String reservatUserid) {
		this.reservatUserid = reservatUserid;
	}

	public int getReservatPeople() {
		return reservatPeople;
	}

	public void setReservatPeople(int reservatPeople) {
		this.reservatPeople = reservatPeople;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Date getReservatCdate() {
		return reservatCdate;
	}

	public void setReservatCdate(Date reservatCdate) {
		this.reservatCdate = reservatCdate;
	}

	@Override
	public String toString() {
		return "ReservatVO [reservatNo=" + reservatNo + ", hotelNo=" + hotelNo + ", hotelTitle=" + hotelTitle + ", reservatNight=" + reservatNight
				+ ", reservatPrice=" + reservatPrice + ", reservatUserid=" + reservatUserid + ", reservatPeople="
				+ reservatPeople + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", reservatCdate="
				+ reservatCdate + "]";
	}
}
