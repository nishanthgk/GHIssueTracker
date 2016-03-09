package com.example.ghissuetracker;

import java.util.ArrayList;
import java.util.List;

import com.example.ghissuetracker.model.FetchIssueResponse;
import com.example.ghissuetracker.model.FetchRepoResponse;
import com.example.ghissuetracker.rest.AppUtils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListReposActivity extends Activity {
	
	TextView mCurrentUser;
	ListView repoListView;
	String mSelectedRepo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext= this;
		setContentView(R.layout.activity_list_repos);
		
		mCurrentUser = (TextView) findViewById(R.id.tv_current_user);
		mCurrentUser.setText(AppState.getInstance().getCurrentUser());
		repoListView = (ListView) findViewById(R.id.list);
		
		ArrayList<String> repos = new ArrayList<String>();
		
		for(FetchRepoResponse fetchRepo : AppState.getInstance().getRepos()){
			repos.add(fetchRepo.getName());
		}
		
		ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_view_item,repos);
		repoListView.setAdapter(adapter);
		
		repoListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
			    
				mSelectedRepo = ((TextView) view).getText().toString();
				AppState.getInstance().setCurrentRepo(mSelectedRepo);
				
				new IssueFetcherTask().execute(AppState.getInstance().getCurrentUser(), mSelectedRepo);
			}
		});
		
	}
	
	private Context mContext;
	
	class IssueFetcherTask extends AsyncTask<String, Void, List<FetchIssueResponse>> {

		@Override
		protected List<FetchIssueResponse> doInBackground(String... params) {
			// TODO Auto-generated method stub
			return AppUtils.fetchIssues(params[0], params[1]);
		}
		
		ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new ProgressDialog(mContext);
			dialog.setMessage(getResources().getString(R.string.fetching_Issues));
			dialog.setIndeterminate(true);
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected void onPostExecute(List<FetchIssueResponse> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			dialog.dismiss();
			if(result == null || result.size() == 0) {
				Toast.makeText(getApplicationContext(), "No issues found with " + mSelectedRepo, Toast.LENGTH_LONG).show();
				return;
			}
			
			AppState.getInstance().setIssues(result);
			Intent intent = new Intent(getApplicationContext(), ListIssueActivity.class );
			startActivity(intent);
			
			
		}
		
	}
	
}
