package com.balancer.data;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.balancer.R;
import com.balancer.android.HouseActivity;
import com.balancer.service.WeatherInformation;



public class Device{

	private boolean turnedOn;
	
	private Data data;

	public Device(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public boolean checkWeather(WeatherInformation data, float temperatureDesired, HouseActivity house) {
		System.out.println("checkWeather: 1");
		boolean result = false;
		if(data.getTemperature() > temperatureDesired){
			System.out.println("checkWeather: 2");	
			result = true;
			turnedOn = true;
			//Drawable drawable = house.getApplicationContext().getResources().getDrawable(R.drawable.red);
			ImageView imageView = (ImageView) house.findViewById(R.id.mask);
			//imageView.setBackground(drawable);
			imageView.setBackgroundResource(R.drawable.green);
		}else{
			System.out.println("checkWeather: 3");
			turnOff(house);
		}

		return result;
	}
	
	private void turnOff(HouseActivity house){
		System.out.println("turnOff: 1");
		this.turnedOn = false;
		//Drawable drawable = house.getApplicationContext().getResources().getDrawable(R.drawable.red);
		ImageView imageView = (ImageView) house.findViewById(R.id.mask);
		//imageView.setBackground(drawable);
		imageView.setBackgroundResource(R.drawable.red);
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
}
