package com.example.latihan1dessypermatasari;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;

public class ContactDetailTab extends Activity {

	ActionBar.Tab Inbox, Outbox ;
	Fragment fragmentTabInbox = new FragmentTabInbox();
	Fragment fragmentTabOutbox = new FragmentTabOutbox();
	
	 @SuppressLint("NewApi") @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activitytab);
	        
	        ActionBar actionBar = getActionBar();
	        actionBar.setDisplayShowHomeEnabled(false);
	        actionBar.setDisplayShowTitleEnabled(false);
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	        
	        Inbox = actionBar.newTab().setText("Inbox");
	        Outbox = actionBar.newTab().setText("Outbox");

	        Inbox.setTabListener(new TabListener(fragmentTabInbox));
	        Outbox.setTabListener(new TabListener(fragmentTabOutbox));
	        
	        actionBar.addTab(Inbox);
			actionBar.addTab(Outbox);
			
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
