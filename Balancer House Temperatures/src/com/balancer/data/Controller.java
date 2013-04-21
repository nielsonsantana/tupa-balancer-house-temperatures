package com.balancer.data;

import java.util.ArrayList;
import com.balancer.service.*;


public class Controller extends Thread {
	
	
	private ArrayList<Device> devices;
	
	private WeatherInformation WeatherInformation;
	
	private float desiredTemperature;

	private boolean keepAlive;
	
	private HouseActivity house;
	
	public Controller(HouseActivity house){
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
			//Service serv = new Service();
			//this.WeatherInformation = serv.connect();
			
			WeatherInformation weatherInformation[] = 
					{new WeatherInformation(33),
					 new WeatherInformation(28), new WeatherInformation(31), new WeatherInformation(27),
					 new WeatherInformation(30), new WeatherInformation(26)};
			
			for (int i = 0; i < weatherInformation.length; i++) {
				System.out.println("==============================");
				System.out.println("Local Temperature:" + weatherInformation[i].getTemperature());
				for (Device device : this.devices) {
					device.checkWeather(weatherInformation[i], this.desiredTemperature);
					System.out.println("Turned On:" + device.isTurnedOn());
					System.out.println("==============================");
				}
				try {
					Controller.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
	
	
	public WeatherInformation getWeatherInformation() {
		return WeatherInformation;
	}

	public void setWeatherInformation(WeatherInformation WeatherInformation) {
		this.WeatherInformation = WeatherInformation;
	}
	

	public float getDesiredTemperature() {
		return desiredTemperature;
	}

	public void setDesiredTemperature(float desiredTemperature) {
		this.desiredTemperature = desiredTemperature;
	}
	
}
