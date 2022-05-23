package edu.spring.hotel.domain;

import java.util.Date;

public class ProjectVO {
	private int projectNo;
	private String projectTitle;
	private String projectContent;
	private String writer;
	Date projectCdate;
	
	public ProjectVO() {}

	public ProjectVO(int projectNo, String projectTitle, String projectContent, String writer, Date projectCdate) {
		super();
		this.projectNo = projectNo;
		this.projectTitle = projectTitle;
		this.projectContent = projectContent;
		this.writer = writer;
		this.projectCdate = projectCdate;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getProjectCdate() {
		return projectCdate;
	}

	public void setProjectCdate(Date projectCdate) {
		this.projectCdate = projectCdate;
	}

	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectContent="
				+ projectContent + ", writer=" + writer + ", projectCdate=" + projectCdate + "]";
	}
	
	

}
