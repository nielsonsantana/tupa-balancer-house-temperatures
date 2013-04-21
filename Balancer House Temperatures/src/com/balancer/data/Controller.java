package com.balancer.data;

import java.util.ArrayList;

import com.balancer.service.*;


public class Controller extends Thread {
	
	
	private ArrayList<Device> devices;
	
	private WheaterInformation data;

	private boolean keepAlive;
	
	public Controller(){
		this.devices = new ArrayList<Device>();
		this.keepAlive = true;
	}
	
	public void addDevice(Device device){
		devices.add(device);
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
	
}
