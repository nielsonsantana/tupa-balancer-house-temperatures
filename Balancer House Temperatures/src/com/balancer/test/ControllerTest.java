package com.balancer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.balancer.data.Controller;
//import com.balancer.data.Data;
import com.balancer.service.WheaterInformation;

public class ControllerTest {

	@Test
	public void shoud_start_controller_and_turn_it_down() throws InterruptedException {
		Controller controller = new Controller(); 
		
		controller.setData(new WheaterInformation(10));
		
		if(true){
			controller.sleep(100);
		}
	
		controller.start();
		
		fail("Not yet implemented");
	}

}
