package com.balancer.service;

public class WeatherInformation {
	
	
	private double temperature;
	private double feelsLike;
	
	public WeatherInformation() {
		super();
	}
	
	
	public WeatherInformation(float temperature) {
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