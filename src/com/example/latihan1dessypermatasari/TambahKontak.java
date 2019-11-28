package com.example.latihan1dessypermatasari;


import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
=======

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
>>>>>>> d5179071590cf082258999beefc5356e333b0211
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

public class TambahKontak extends Activity {
	private TextView judul;
	private EditText nama;
	private EditText alamat;
	private EditText email;
	private EditText phone;
	private EditText dob;
	private Button simpan;
	private ListView lv;
	private ProgressDialog pDialog;
	private String TAG = MainActivity.class.getSimpleName();
	private String response_url ;
	
	
	private static String url = "http://apilearning.totopeto.com/contacts/";
	 ArrayList<HashMap<String, String>> contactList;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_kontak);
        
        contactList = new ArrayList<HashMap<String, String>>();
        judul = (TextView) findViewById(R.id.txtview);
        nama  = (EditText) findViewById(R.id.etnama);
        alamat = (EditText) findViewById(R.id.etalamat);
        email = (EditText) findViewById(R.id.etemail);
        phone = (EditText) findViewById(R.id.etphone);
        dob = (EditText)findViewById(R.id.etdob);
        simpan = (Button) findViewById(R.id.btnsimpan);
        lv = (ListView) findViewById(R.id.list);
        
       simpan.setOnClickListener(simpankontakClick);
	}
	private View.OnClickListener simpankontakClick = new View.OnClickListener () {
		@Override
		public void onClick(View v) {
<<<<<<< HEAD
			Intent intent=new Intent(TambahKontak.this,MainActivity.class);
			new SaveKontak().execute();
			TambahKontak.this.finish();
			startActivity(intent);
=======
			new SaveKontak().execute();
>>>>>>> d5179071590cf082258999beefc5356e333b0211
		}
	};
	 private class SaveKontak extends AsyncTask<Void, Void, Void> {
	   	 
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            // Showing progress dialog
	            pDialog = new ProgressDialog(TambahKontak.this);
	            pDialog.setMessage("Please wait...");
	            pDialog.setCancelable(false);
	            pDialog.show();
	 
	        }
	        
	        protected void onPostExecute(Void result){
	        	super.onPostExecute(result);
	        	if(pDialog.isShowing()){pDialog.dismiss();}
	        	 if (response_url !=null){
	        		 try{
	        			 JSONObject jsonObj = new JSONObject(response_url);
	        			 if (jsonObj.getString("status")=="400"){
	        				 Toast.makeText(getApplicationContext(), jsonObj.getString("failed add contacts"),Toast.LENGTH_LONG).show();
	        			 }else{
	        				 TambahKontak.this.finish();
	        				 
	        			 }
	        			 }catch (final JSONException e) {
	                         Log.e(TAG, "Json parsing error: " + e.getMessage());
	                         runOnUiThread(new Runnable() {
	                             @Override
	                             public void run() {
	                                 Toast.makeText(getApplicationContext(),
	                                         "Json parsing error: " + e.getMessage(),
	                                         Toast.LENGTH_LONG)
	                                         .show();
	                             }
	                             
	                         });
	        			 }
	        		 }else{
	        			 
	        	                Log.e(TAG, "Couldn't get json from server.");
	        	                runOnUiThread(new Runnable() {
	        	                    @Override
	        	                    public void run() {
	        	                        Toast.makeText(getApplicationContext(),
	        	                                "Couldn't get json from server. Check LogCat for possible errors!",
	        	                                Toast.LENGTH_LONG)
	        	                                .show();
	        	                    }
	        	                });
	        	 
	        	            }
	        	 
	        			 }
	        	        
	        	 
	        @Override
	        protected Void doInBackground(Void... arg0) {
	        	HttpHandler data = new HttpHandler();
	       	 
	            // Making a request to url and getting response
	        	String post_params = null;

	        	String jsonStr = data.makePostRequest(url,post_params);
	            Log.e(TAG,"Response  from URL: " + jsonStr);
	            response_url = jsonStr;
	        	JSONObject params = new JSONObject();
	        	try {
	        		params.put("nama",nama.getText().toString()); 
	        		params.put("alamat",alamat.getText().toString());
	        		params.put("email",email.getText().toString());
	        		params.put("phone",phone.getText().toString());
	        		params.put("dob",dob.getText().toString());
	        		post_params = params.toString();
	        		
	        	}catch (JSONException e) {
	        		e.printStackTrace();
	        	}
	        	           return null;
	        } 
	 }
}
	       
<<<<<<< HEAD


=======
	        	 
>>>>>>> d5179071590cf082258999beefc5356e333b0211
