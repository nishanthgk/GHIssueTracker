package com.example.ghissuetracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class FetchIssueResponse implements Serializable {
	
	@SerializedName("url")
	private String url;
	@SerializedName("repository_url")
	private String repository_url;
	@SerializedName("labels_url")
	private String labels_url;
	@SerializedName("comments_url")
	private String comments_url;
	@SerializedName("events_url")
	private String events_url;
	@SerializedName("html_url")
	private String html_url;
	@SerializedName("id")
	private int id;
	@SerializedName("number")
	private int number;
	@SerializedName("title")
	private String title;
	@SerializedName("user")
	private UserList user;
	@SerializedName("labels")
	private ArrayList<LabelInfo> labels;
	@SerializedName("state")
	private String state;
	@SerializedName("locked")
	private String locked;
	@SerializedName("assignee")
	private List<AssigneeDetails> assignee;
	@SerializedName("milestone")
	private List<MilestoneDetails> milestone;
	@SerializedName("comments")
	private String comments;
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("updated_at")
	private String updated_at;
	@SerializedName("closed_at")
	private String closed_at;
	@SerializedName("body")
	private String body;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRepository_url() {
		return repository_url;
	}
	public void setRepository_url(String repository_url) {
		this.repository_url = repository_url;
	}
	public String getLabels_url() {
		return labels_url;
	}
	public void setLabels_url(String labels_url) {
		this.labels_url = labels_url;
	}
	public String getComments_url() {
		return comments_url;
	}
	public void setComments_url(String comments_url) {
		this.comments_url = comments_url;
	}
	public String getEvents_url() {
		return events_url;
	}
	public void setEvents_url(String events_url) {
		this.events_url = events_url;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UserList getUser() {
		return user;
	}
	public void setUser(UserList user) {
		this.user = user;
	}
	public ArrayList<LabelInfo> getLabels() {
		return labels;
	}
	public void setLabels(ArrayList<LabelInfo> labels) {
		this.labels = labels;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public List<AssigneeDetails> getAssignee() {
		return assignee;
	}
	public void setAssignee(List<AssigneeDetails> assignee) {
		this.assignee = assignee;
	}
	public List<MilestoneDetails> getMilestone() {
		return milestone;
	}
	public void setMilestone(List<MilestoneDetails> milestone) {
		this.milestone = milestone;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
