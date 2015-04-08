/*
 * A Custom Progress Dialog Example by Usman Ali Butt.
 * 
 *  */

package com.uab.customprogressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btShowDialog = (Button) findViewById(R.id.btShowDialog);
		btShowDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new ProgressAsyncTask(MainActivity.this).execute();
			}
		});
	}

	// Async task to show progress dialog
	private class ProgressAsyncTask extends AsyncTask<Void, Void, Void> {
		private final ProgressDialog progressDialog;

		public ProgressAsyncTask(Context context) {
			progressDialog = new CustomProgressDialog(context, "Loading...");
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// sleep for 7 seconds
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			progressDialog.cancel();
		}
	}
}
