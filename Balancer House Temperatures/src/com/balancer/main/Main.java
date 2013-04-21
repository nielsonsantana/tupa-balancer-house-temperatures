package com.balancer.main;

import java.util.Scanner;

import com.balancer.data.Controller;
import com.balancer.data.Data;
import com.balancer.service.WheaterInformation;

public class Main {

	public static void main(String []args){
		
		Scanner scanner = new Scanner(System.in);
		
		int entry = -1;
		
		System.out.println("Pressione 0 para sair!!");
		
		Controller controller = new Controller();
		
		do {
			
			int temperature = 22 + (int)(Math.random()*40);
			
			WheaterInformation data = new WheaterInformation(temperature);
			controller.setDesiredTemperature(temperature);
			
			controller.setData(data);
			controller.start();
			entry = scanner.nextInt();
			
		} while (entry != 0);
		
	}
}
