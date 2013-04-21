package com.balancer.main;

import java.util.Scanner;

import com.balancer.data.Controller;
import com.balancer.data.Data;
import com.balancer.service.WeatherInformation;

public class Main {

	public static void main(String []args){
		
		Scanner scanner = new Scanner(System.in);
		
		int entry = -1;
		
		System.out.println("Pressione 0 para sair!!");
		
		Controller controller = new Controller();
		
		int temperature = 27;
			
		controller.setDesiredTemperature(temperature);
		controller.start();
	}
}
