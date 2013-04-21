package com.balancer.data;

import com.balancer.service.*;

public class Service {

	public WeatherInformation connect() {
		WeatherInformation wi;
		WeatherChannel wheaterChannel = new WeatherChannel();
		wi = wheaterChannel.getLocalWheatherByIP();
		
		return wi;
	}

}
