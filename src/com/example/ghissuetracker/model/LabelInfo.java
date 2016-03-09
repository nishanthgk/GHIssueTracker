package com.example.ghissuetracker.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class LabelInfo implements Serializable{

	@SerializedName("url")
	private String url;
	@SerializedName("name")
	private String name;
	@SerializedName("color")
	private String color;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
