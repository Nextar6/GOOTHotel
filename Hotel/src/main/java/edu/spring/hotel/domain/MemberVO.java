package edu.spring.hotel.domain;

import java.util.Date;

public class MemberVO {
	int memberNo;
	String memberUserid;
	String memberPassword;
	String memberEmail;
	String memberSSN;
	String memberPhone;
	String memberName;
	String memberAddress;
	Date memberCdate;
	
	public MemberVO() {}
	
	public MemberVO(int memberNo, String memberUserid, String memberPassword, String memberEmail, String memberSSN,
			String memberPhone, String memberName, String memberAddress, Date memberCdate) {
		this.memberNo = memberNo;
		this.memberUserid = memberUserid;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberSSN = memberSSN;
		this.memberPhone = memberPhone;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberCdate = memberCdate;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getMemberUserid() {
		return memberUserid;
	}
	
	public void setMemberUserid(String memberUserid) {
		this.memberUserid = memberUserid;
	}
	
	public String getMemberPassword() {
		return memberPassword;
	}
	
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	public String getMemberSSN() {
		return memberSSN;
	}
	
	public void setMemberSSN(String memberSSN) {
		this.memberSSN = memberSSN;
	}
	
	public String getMemberPhone() {
		return memberPhone;
	}
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberAddress() {
		return memberAddress;
	}
	
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	public Date getMemberCdate() {
		return memberCdate;
	}
	
	public void setMemberCdate(Date memberCdate) {
		this.memberCdate = memberCdate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberUserid=" + memberUserid + ", memberPassword="
				+ memberPassword + ", memberEmail=" + memberEmail + ", memberSSN="
				+ memberSSN + ", memberPhone=" + memberPhone + ", memberName="
				+ memberName + ", memberAddress=" + memberAddress + ", memberCdate=" + memberCdate
				+ "]";
	}
	
}
