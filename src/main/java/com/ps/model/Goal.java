package com.ps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GoalTestId")
public class Goal {

	@Id
	
	private int id;
	private String title;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Goal(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", title=" + title + "]";
	}

}
