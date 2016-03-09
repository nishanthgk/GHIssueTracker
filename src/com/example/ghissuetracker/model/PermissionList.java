package com.example.ghissuetracker.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class PermissionList implements Serializable{

	@SerializedName("admin")
	private String admin;
	@SerializedName("push")
	private String push;
	@SerializedName("pull")
	private String pull;
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPush() {
		return push;
	}
	public void setPush(String push) {
		this.push = push;
	}
	public String getPull() {
		return pull;
	}
	public void setPull(String pull) {
		this.pull = pull;
	}
	
	
	
}
