package com.balancer.service;

import java.io.*;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WheaterChannel {
	
	private final String baseApiUrl = "http://api.wunderground.com/api/70c15bc4cb67a083";
	
	public WheaterInformation getWheather(String country, String city) {
		String url = this.baseApiUrl + "/conditions/q/" + country + "/" + city + ".json";
		String json = this.getJsonFromUrl(url);
		
		
		return this.getWheaterInformationFromJson(json);
	}
	
	public WheaterInformation getWheather(double latitude, double longitude) {
		String url = this.baseApiUrl + "/conditions/q/" + Double.toString(latitude) + "," + Double.toString(longitude) + ".json";
		String json = this.getJsonFromUrl(url);
		
		return this.getWheaterInformationFromJson(json);
	}
	
	public WheaterInformation getLocalWheatherByIP() {
		String url = this.baseApiUrl + "/conditions/q/autoip.json";
		String json = this.getJsonFromUrl(url);
		
		return this.getWheaterInformationFromJson(json);
	}
	
	private String getJsonFromUrl(String url) {
		
		URL urlObj;
		HttpURLConnection conn;
		
		try {
			urlObj = new URL(url);
			
			conn = (HttpURLConnection)urlObj.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String result = "";
			
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			
			rd.close();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private WheaterInformation getWheaterInformationFromJson(String json) {
		JSONParser parser = new JSONParser();
		WheaterInformation wi = new WheaterInformation();
		
		try {
	 
			Object obj = parser.parse(json);
	 
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject currentObservation = (JSONObject)jsonObject.get("current_observation");
			
			wi.setTemperature(Double.parseDouble(currentObservation.get("temp_c").toString()));
			wi.setFeelsLike(Double.parseDouble(currentObservation.get("feelslike_c").toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return wi;
	
	}
}