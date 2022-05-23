package edu.spring.hotel.domain;

public class BoardVO {
	private String boardCategory;
	private String boardTitle;
	private String writer;
	private String boardContent;

	public BoardVO(String boardCategory, String boardTitle, String boardContent) {
		super();
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "boardVO [boardCategory=" + boardCategory + ", boardTitle=" + boardTitle + ", writer=" + writer
				+ ", boardContent=" + boardContent + "]";
	}

}
