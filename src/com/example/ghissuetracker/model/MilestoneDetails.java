package com.example.ghissuetracker.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MilestoneDetails implements Serializable{
	
	@SerializedName("url")
	private String url;
	@SerializedName("html_url")
	private String html_url;
	@SerializedName("labels_url")
	private String labels_url;
	@SerializedName("id")
	private String id;
	@SerializedName("number")
	private String number;
	@SerializedName("state")
	private String state;
	@SerializedName("title")
	private String title;
	@SerializedName("description")
	private String description;
	@SerializedName("creator")
	private List<CreatorDetails> creator;
	@SerializedName("open_issues")
	private String open_issues;
	@SerializedName("closed_issues")
	private String closed_issues;
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("updated_at")
	private String updated_at;
	@SerializedName("closed_at")
	private String closed_at;
	@SerializedName("due_on")
	private String due_on;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getLabels_url() {
		return labels_url;
	}
	public void setLabels_url(String labels_url) {
		this.labels_url = labels_url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CreatorDetails> getCreator() {
		return creator;
	}
	public void setCreator(List<CreatorDetails> creator) {
		this.creator = creator;
	}
	public String getOpen_issues() {
		return open_issues;
	}
	public void setOpen_issues(String open_issues) {
		this.open_issues = open_issues;
	}
	public String getClosed_issues() {
		return closed_issues;
	}
	public void setClosed_issues(String closed_issues) {
		this.closed_issues = closed_issues;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getClosed_at() {
		return closed_at;
	}
	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}
	public String getDue_on() {
		return due_on;
	}
	public void setDue_on(String due_on) {
		this.due_on = due_on;
	}
	
	
	
}
