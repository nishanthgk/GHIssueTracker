package com.example.ghissuetracker.rest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.example.ghissuetracker.AppState;
import com.example.ghissuetracker.BuildConfig;
import com.example.ghissuetracker.model.FetchIssueResponse;
import com.example.ghissuetracker.model.FetchRepoResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.util.BufferedReader;

import android.util.Log;

public class AppUtils {
	
	// DOMAIN ADDRESS
	public static final String GITHUB_API = "https://api.github.com/";
	
	// MIDPOINTS
	public static final String MIDPOINT_REPO = "users/";
	public static final String MIDPOINT_ISSUES = "repos/";
	
	// ENDPOINTS
	public static final String ENDPOINT_FETCH_USER_REPO = "/repos";
	public static final String ENDPOINT_FETCH_REPO_ISSUE = "/issues";
	
	public static List<FetchRepoResponse> fetchRepo(String userId) {
		
		List<FetchRepoResponse> response = null;
		String uri = GITHUB_API + MIDPOINT_REPO + userId + ENDPOINT_FETCH_USER_REPO;
		
		if(BuildConfig.DEBUG) {
			Log.d("URI :", uri);
		}
		
		try {
			URL url = new URL(uri);
			HttpsURLConnection conn  = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", userId);
			conn.setRequestProperty("Accept", "application/json; charset=utf-8");
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			response = new Gson().fromJson(br, new TypeToken<List<FetchRepoResponse>>(){}.getType());
            conn.disconnect();
			
//			int code = conn.getResponseCode();
//			
//			if(code >= 200 && code <=204) {
//				response = new Gson().fromJson(new InputStreamReader(conn.getInputStream()), FetchRepoResponse.class);
//			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
	}
	
	public static List<FetchIssueResponse> fetchIssues(String userId, String repoId) {
		
		List<FetchIssueResponse> response = null;
		String uri = GITHUB_API + MIDPOINT_ISSUES + userId + "/" + repoId + ENDPOINT_FETCH_REPO_ISSUE;
		
		if(BuildConfig.DEBUG) {
			Log.d("URI :", uri);
		}
		
		try {
			URL url = new URL(uri);
			HttpsURLConnection conn  = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", AppState.getInstance().getCurrentUser());
			conn.setRequestProperty("Accept", "application/json; charset=utf-8");
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			if(BuildConfig.DEBUG) {
				Log.d("Output :", conn.getInputStream().toString());
			}
			response = new Gson().fromJson(br, new TypeToken<List<FetchIssueResponse>>(){}.getType());
            conn.disconnect();
			
//			int code = conn.getResponseCode();
//			
//			if(code >= 200 && code <=204) {
//				response = new Gson().fromJson(new InputStreamReader(conn.getInputStream()), FetchRepoResponse.class);
//			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
	}
}
