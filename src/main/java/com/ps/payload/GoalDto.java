package com.ps.payload;

public class GoalDto {

	private String id;
	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GoalDto(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public GoalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
