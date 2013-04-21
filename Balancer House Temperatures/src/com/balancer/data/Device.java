package com.balancer.data;

import com.balancer.service.WheaterInformation;


public class Device extends Thread {

	private boolean turnedOn;
	
	private Data data;

	public Device(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public boolean checkWeather(WheaterInformation data) {
		
		boolean result = false;
		if(data.getTemperature() >= Constants.TEMPERATURE_FACTOR){
			result = true;
			turnedOn = true;
		}else{
			turnOff();
		}
		System.out.println("==============================");
		System.out.println("Local Temperature:" + data.getTemperature());
		System.out.println("Turned On:" + isTurnedOn());
		System.out.println("==============================");
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
