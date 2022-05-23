package edu.spring.hotel.domain;

import java.util.Date;

public class PolicyVO {
	private int policyNo;
	private String policyTitle;
	private String policyContent;
	private String writer;
	Date policyCdate;
	
	public PolicyVO() {}
	
	public PolicyVO(int policyNo, String policyTitle, String policyContent, String writer, Date policyCdate) {
		super();
		this.policyNo = policyNo;
		this.policyTitle = policyTitle;
		this.policyContent = policyContent;
		this.writer = writer;
		this.policyCdate = policyCdate;
	}

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyTitle() {
		return policyTitle;
	}

	public void setPolicyTitle(String policyTitle) {
		this.policyTitle = policyTitle;
	}

	public String getPolicyContent() {
		return policyContent;
	}

	public void setPolicyContent(String policyContent) {
		this.policyContent = policyContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getPolicyCdate() {
		return policyCdate;
	}

	public void setPolicyCdate(Date policyCdate) {
		this.policyCdate = policyCdate;
	}

	@Override
	public String toString() {
		return "PolicyVO [policyNo=" + policyNo + ", policyTitle=" + policyTitle + ", policyContent=" + policyContent
				+ ", writer=" + writer + ", policyCdate=" + policyCdate + "]";
	}
	
	

}
