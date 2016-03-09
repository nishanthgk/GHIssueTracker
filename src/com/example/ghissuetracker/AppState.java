package com.example.ghissuetracker;

import java.util.List;

import com.example.ghissuetracker.model.FetchIssueResponse;
import com.example.ghissuetracker.model.FetchRepoResponse;

public class AppState {
	static private AppState mInstance;
	
	synchronized public static AppState getInstance() {
		if(mInstance == null) {
			mInstance = new AppState();
		}
		return mInstance;
	}
	
	private List<FetchRepoResponse> repos;
	private String currentUser;

	private List<FetchIssueResponse> issues;
	private String currentRepo;

	public List<FetchRepoResponse> getRepos() {
		return repos;
	}

	public void setRepos(List<FetchRepoResponse> repos) {
		this.repos = repos;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public List<FetchIssueResponse> getIssues() {
		return issues;
	}

	public void setIssues(List<FetchIssueResponse> issues) {
		this.issues = issues;
	}

	public String getCurrentRepo() {
		return currentRepo;
	}

	public void setCurrentRepo(String currentRepo) {
		this.currentRepo = currentRepo;
	}
	
	
}
