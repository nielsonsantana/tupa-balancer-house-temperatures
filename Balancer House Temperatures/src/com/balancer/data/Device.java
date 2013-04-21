package com.balancer.data;

import com.balancer.service.WeatherInformation;


public class Device extends Thread {

	private boolean turnedOn;
	
	private Data data;

	public Device(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public boolean checkWeather(WeatherInformation data, float temperatureDesired) {
		
		boolean result = false;
		if(data.getTemperature() > temperatureDesired){
			result = true;
			turnedOn = true;
		}else{
			turnOff();
		}

		return result;
	}
	
	private void turnOff(){
		this.turnedOn = false;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
}
