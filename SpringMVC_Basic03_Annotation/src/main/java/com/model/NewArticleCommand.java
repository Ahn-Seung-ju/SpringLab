package com.model;

//DB에 Article table이 있다고 가정 1:1 매핑되는 클래스(DTO)
public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "NewArticleCommand [parentId=" + parentId + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
