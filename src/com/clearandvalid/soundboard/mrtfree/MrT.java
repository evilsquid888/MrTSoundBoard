package com.clearandvalid.soundboard.mrtfree;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.ads.*;

public class MrT extends Activity implements OnClickListener {
   private MediaPlayer a,b,c,d,e,f,g,h,i,j,k,l;
   private AdView adView;


    @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       // Native rate is 44.1kHz 16 bit stereo, but
       // to save space we just use MPEG-3 22kHz mono
       a = MediaPlayer.create(this, R.raw.a);
       b = MediaPlayer.create(this, R.raw.b);
       c = MediaPlayer.create(this, R.raw.c);
       d = MediaPlayer.create(this, R.raw.d);
       e = MediaPlayer.create(this, R.raw.e);
       f = MediaPlayer.create(this, R.raw.f);
       g = MediaPlayer.create(this, R.raw.g);
       h = MediaPlayer.create(this, R.raw.h);
       i = MediaPlayer.create(this, R.raw.i);
       j = MediaPlayer.create(this, R.raw.j);
       k = MediaPlayer.create(this, R.raw.k);
       l = MediaPlayer.create(this, R.raw.l);
       
       // Setup click listeners
       setContentView(R.layout.main);
       
       View button0 = this.findViewById(R.id.button0);
       button0.setOnClickListener(this);
       View button1 = this.findViewById(R.id.button1);
       button1.setOnClickListener(this);
       View button2 = this.findViewById(R.id.button2);
       button2.setOnClickListener(this);
       View button3 = this.findViewById(R.id.button3);
       button3.setOnClickListener(this);
       View button4 = this.findViewById(R.id.button4);
       button4.setOnClickListener(this);
       View button5 = this.findViewById(R.id.button5);
       button5.setOnClickListener(this);
       View button6 = this.findViewById(R.id.button6);
       button6.setOnClickListener(this);
       View button7 = this.findViewById(R.id.button7);
       button7.setOnClickListener(this);
       View button8 = this.findViewById(R.id.button8);
       button8.setOnClickListener(this);
       View button9 = this.findViewById(R.id.button9);
       button9.setOnClickListener(this);
       View button10 = this.findViewById(R.id.button10);
       button10.setOnClickListener(this);
       View button11 = this.findViewById(R.id.button11);
       button11.setOnClickListener(this);

        // Create the adView
        adView = new AdView(this, AdSize.BANNER, "a14c421464e9c65");

        // Lookup your LinearLayout assuming it's been given
        // the attribute android:id="@+id/mainLayout"
        LinearLayout layout = (LinearLayout)findViewById(R.id.screen0);

        // Add the adView to it
        layout.addView(adView);

        // Initiate a generic request to load it with an ad
        adView.loadAd(new AdRequest());

   }
 
   @Override
   public void onClick(View v) {
	   MediaPlayer mp = null;
	   switch (v.getId()) {
	   
	   case R.id.button0:
		   mp=a;
		   break;
	   case R.id.button1:
		   mp=b;
		   break;
	   case R.id.button2:
		   mp=c;
		   break;
	   case R.id.button3:
		   mp=d;
		   break;
	   case R.id.button4:
		   mp=e;
		   break;
	   case R.id.button5:
		   mp=f;
		   break;
	   case R.id.button6:
		   mp=g;
		   break;
	   case R.id.button7:
		   mp=h;
		   break;
	   case R.id.button8:
		   mp=i;
		   break;
	   case R.id.button9:
		   mp=j;
		   break;
	   case R.id.button10:
		   mp=k;
		   break;
	   case R.id.button11:
		   mp=l;
		   break;		   
	   
	   }
	   
	   mp.seekTo(0);
	   mp.start();
	   
   } 
   
	// Called only the first time the options menu is displayed.
	// Create the menu entries.
	// Menu adds items in the order shown.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.layout.menu, menu);
	    
	    // Parameters for menu.add are:
	    // group -- Not used here.
	    // id -- Used only when you want to handle and identify the click yourself.
	    // title
	    /*
	    menu.add("About...");
	    menu.add("Quit");
	    */
	    return true;
	}
	
	// Activity callback that lets your handle the selection in the class.
	// Return true to indicate that you've got it, false to indicate
	// that it should be handled by a declared handler object for that
	// item (handler objects are discouraged for reasons of efficiency).
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch(item.getItemId()) {
		
		case R.id.about:
			startActivity(new Intent(this, About.class));
		    return true;
		
		case R.id.quit:
			finish();
			return true;
		   
		}
	
		return false;
	
	}
     
}
