package com.example.ghissuetracker;

import java.util.List;

import com.example.ghissuetracker.model.FetchRepoResponse;
import com.example.ghissuetracker.rest.AppUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginActivity extends Activity{
	
	private EditText etUsername;
	//private EditText etPassword;
	private Button btnLogin;
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mContext = this;
		
		setContentView(R.layout.activity_user_login);
		
		etUsername = (EditText) findViewById(R.id.et_username);
		// etPassword = (EditText) findViewById(R.id.et_password);
		btnLogin = (Button) findViewById(R.id.btn_login);
		
		btnLogin.setOnClickListener(mLoginListener);
		
	}
	
	String userName;
	
	OnClickListener mLoginListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			userName = etUsername.getText().toString();
			//String passWord = etPassword.getText().toString();
			
			if(("".compareTo(userName.trim())) == 0) {
				Toast.makeText(getApplicationContext(), "Please Enter Credentials", Toast.LENGTH_LONG).show();
				return;
			} 
			
			ConnectivityManager connMgr = (ConnectivityManager) 
			        getSystemService(Context.CONNECTIVITY_SERVICE);
			    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			    if (networkInfo != null && networkInfo.isConnected()) {
			    	new RepoFetcher().execute(userName);
			    } else {
			        Toast.makeText(getApplicationContext(), "Unable to connect to the internet", Toast.LENGTH_LONG).show();
			    }
			
			
			
		}
		
		
	};
	
	class RepoFetcher extends AsyncTask<String, Void, List<FetchRepoResponse>> {

		@Override
		protected List<FetchRepoResponse> doInBackground(String... params) {
			// TODO Auto-generated method stub
			return AppUtils.fetchRepo(params[0]);
		}
		
		ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new ProgressDialog(mContext);
			dialog.setMessage(getResources().getString(R.string.fetching_repos));
			dialog.setIndeterminate(true);
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected void onPostExecute(List<FetchRepoResponse> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			dialog.dismiss();
			if(result == null) {
				Toast.makeText(getApplicationContext(), "Error: No Repos Found", Toast.LENGTH_LONG).show();
				return;
			}
			
			AppState.getInstance().setCurrentUser(userName);
			AppState.getInstance().setRepos(result);
			Intent intent = new Intent(getApplicationContext(), ListReposActivity.class );
			startActivity(intent);
			
			
		}
		
		
		
	}
	
}
