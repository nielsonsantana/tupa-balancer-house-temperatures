package com.balancer.data;

import com.balancer.service.*;

public class Service {

	public WheaterInformation connect() {
		WheaterInformation wi;
		WheaterChannel wheaterChannel = new WheaterChannel();
		wi = wheaterChannel.getLocalWheatherByIP();
		
		return wi;
	}

}
