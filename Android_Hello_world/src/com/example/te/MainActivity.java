package com.example.te;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.httpclient.HttpException;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void sendMessage(View view) {
		
//		System.out.println("-----------sdf----");
//		 try {
//			Notify("You've received new message", AppHttpClient.get("http://androidexample.com/media/webservice/JsonReturn.php"));
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		new CallAPI().execute("http://49.207.107.133:8080/RESTfulExample/rest/hello/mahi");
	}
	
	private void Notify(String notificationTitle, String notificationMessage){
	      NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	      @SuppressWarnings("deprecation")
	      
	      Notification notification = new Notification(R.drawable.abc_btn_radio_material,"New Message", System.currentTimeMillis());
	      Intent notificationIntent = new Intent(this,NotificationView.class);
	      PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notificationIntent, 0);
	      
	      notification.setLatestEventInfo(MainActivity.this, notificationTitle,notificationMessage, pendingIntent);
	      notificationManager.notify(9999, notification);
	   }
	
	
	private class CallAPI extends AsyncTask<String, String, String> {
		 
	    @Override
	    protected String doInBackground(String... params) {
	 
	    	String jsonString = "";
	    	try {
	    		jsonString = AppHttpClient.get(params[0]);
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return jsonString;
	  
	    }
	 
	    protected void onPostExecute(String result) {
	 
	    	TextView tv = (TextView) findViewById(R.id.RRRR);
            tv.setText(result);
	    }
	    
	} 
	   
}
