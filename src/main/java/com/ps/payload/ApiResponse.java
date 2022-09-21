package com.ps.payload;

public class ApiResponse {

	private String message;
	private boolean Sucess;

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean sucess) {
		super();
		this.message = message;
		Sucess = sucess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucess() {
		return Sucess;
	}

	public void setSucess(boolean sucess) {
		Sucess = sucess;
	}

}
