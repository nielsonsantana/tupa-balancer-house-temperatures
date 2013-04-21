package com.balancer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.balancer.data.Controller;
import com.balancer.data.Data;
import com.balancer.data.Device;
import com.balancer.data.Service;
import com.balancer.service.WeatherInformation;

public class DeviceTest {

	@Test
	public void should_verify_external_temperature_enviroment() {
		Service service = new Service();
		
		WeatherInformation data = service.connect();
				data.getTemperature();

		
		assertTrue("Temperature should be less than 35 degrees",
				data.getTemperature() < 35);
	}
	
	@Test
	public void should_create_10_devices() {
		
		ArrayList<Device> house = new ArrayList<Device>(10);
		
		for (int i = 0; i < 10; i++) {
			house.add(new Device(false));
		}
		
		assertEquals("The house shoud have 10 devices", 10, house.size());
	}
	
	@Test
	public void should_turn_on_all_devices_inside_the_house() {

		WeatherInformation data = new WeatherInformation(35);
		
		ArrayList<Device> house = new ArrayList<Device>(10);
		
		for (int i = 0; i < 10; i++) {
			house.add(new Device(false));
		}
		
		boolean result = true;
		
		for (Device device : house) {
			//device.checkWeather(data);
			if(!device.isTurnedOn()){
				result = false;
			}
		}
		
		assertTrue("Should wake up all devices", result);
	}
}
