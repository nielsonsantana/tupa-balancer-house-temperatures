package com.balancer.data;

import java.util.ArrayList;
import com.balancer.service.*;
import com.balancer.android.*;


public class Controller{
	
	
	private ArrayList<Device> devices;
	
	private WeatherInformation WeatherInformation;
	
	private float desiredTemperature;

	private HouseActivity house;
	
	public Controller(HouseActivity house){
		this.devices = new ArrayList<Device>();
		this.house = house;
	}
	
	public void addDevice(Device device){
		devices.add(device);
	}
	
	public void run() {
		//Service serv = new Service();
		//this.WeatherInformation = serv.connect();
		
		WeatherInformation weatherInformation[] = 
				{new WeatherInformation(33),
				 new WeatherInformation(28), new WeatherInformation(31), new WeatherInformation(27),
				 new WeatherInformation(30), new WeatherInformation(26)};
		
		for (int i = 0; i < weatherInformation.length; i++) {
			System.out.println("==============================");
			System.out.println("Local Temperature:" + weatherInformation[i].getTemperature());
			System.out.println("run:1");
			for (Device device : this.devices) {
				System.out.println("run:2");
				device.checkWeather(weatherInformation[i], this.desiredTemperature, house);
				System.out.println("Turned On:" + device.isTurnedOn());
				System.out.println("==============================");
			}
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
	
	public ArrayList<Device> getDevices(){
		return devices;
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
