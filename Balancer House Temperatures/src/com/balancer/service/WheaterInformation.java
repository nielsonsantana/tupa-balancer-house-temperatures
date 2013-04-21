package com.balancer.service;

public class WheaterInformation {
	
	
	private double temperature;
	private double feelsLike;
	
	public WheaterInformation() {
		super();
	}
	
	
	public WheaterInformation(float temperature) {
		this.temperature = temperature;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public double getFeelsLike() {
		return feelsLike;
	}
	
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}
}