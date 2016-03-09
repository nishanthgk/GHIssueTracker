package com.example.ghissuetracker;

import java.util.ArrayList;

import com.example.ghissuetracker.model.FetchIssueResponse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListIssueActivity extends Activity {

	private TextView mCurrentRepo;
	private ListView issueListView;
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_errors);

		mContext = this;
		mCurrentRepo = (TextView) findViewById(R.id.tv_current_user);
		mCurrentRepo.setText(AppState.getInstance().getCurrentRepo());
		issueListView = (ListView) findViewById(R.id.list);

		ArrayList<String> issues = new ArrayList<String>();

		for (FetchIssueResponse fetchIssues : AppState.getInstance().getIssues()) {
			issues.add(fetchIssues.getTitle());
		}

		ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, issues);
		issueListView.setAdapter(adapter);

		issueListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				String issueDesc = AppState.getInstance().getIssues().get(position).getBody();
				if(!issueDesc.equals("")) {
					AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
					builder.setMessage(issueDesc)
					       .setCancelable(false)
					       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					                dialog.cancel();
					           }
					       });
					AlertDialog alert = builder.create();
					alert.show();
				} else {
					Toast.makeText(getApplicationContext(), "No Decription available for " + AppState.getInstance().getIssues().get(position).getTitle(), Toast.LENGTH_LONG).show();
				}
				
				
			}
		});

	}

}
