package com.example.latihan1dessypermatasari;


import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;




public class DetailContact extends Activity {
	
	private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView address;
    private TextView dob;
    
	 
    private static String url = "http://apilearning.totopeto.com/contacts/id";
    ArrayList<HashMap<String, String>> contactList;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact); 

        contactList = new ArrayList<HashMap<String, String>>();
        
        name = (TextView) findViewById(R.id.tvname);
        email = (TextView) findViewById(R.id.tvemail);
        phone = (TextView) findViewById(R.id.tvphone);
        address = (TextView) findViewById(R.id.tvaddress);
        dob = (TextView) findViewById(R.id.tvdob);
        
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        phone.setText(getIntent().getStringExtra("phone"));
        address.setText(getIntent().getStringExtra("address"));
        dob.setText(getIntent().getStringExtra("dob "));
        
	}     	 
}