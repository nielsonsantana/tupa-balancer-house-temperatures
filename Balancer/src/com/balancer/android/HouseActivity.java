package com.balancer.android;

import com.balancer.data.Constants;
import com.balancer.data.Controller;
import com.balancer.data.Device;
import com.balancer.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HouseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_house);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.house, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	public void smartHouseAction(View view){
		runController();
	}
	
	
	private void runController(){
		Controller controller = new Controller(this); 
        
        int temperature = 27; 
             
        controller.setDesiredTemperature(temperature);
        controller.addDevice(new Device(Constants.TURN_OFF));
        controller.run(); 
	}

}
