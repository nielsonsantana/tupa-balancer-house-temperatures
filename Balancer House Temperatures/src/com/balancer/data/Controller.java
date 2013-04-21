package com.balancer.data;

import java.util.ArrayList;

import com.balancer.service.*;


public class Controller extends Thread {
	
	
	private ArrayList<Device> devices;
	
	private WheaterInformation data;
	
	private float desiredTemperature;

	private boolean keepAlive;
	
	public Controller(){
		this.devices = new ArrayList<Device>();
		this.keepAlive = true;
		this.addDevices();
	}
	
	private void addDevices(){
		for (int i = 0; i < 10; i++) {
			devices.add(new Device(false));
		}
	}
	
	@Override
	public void run() {
		super.run();
		while (keepAlive) {
			Service serv = new Service();
			this.data = serv.connect();
			
			for (Device device : this.devices) {
				device.checkWeather(data);
			}
			try {
				Thread.sleep(Constants.TIME_TO_SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Device> getDevices(){
		return devices;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}
	
	
	public WheaterInformation getData() {
		return data;
	}

	public void setData(WheaterInformation data) {
		this.data = data;
	}

	public void setDesiredTemperature(float temperature) {
		this.desiredTemperature = temperature;
		
	}
	
}
