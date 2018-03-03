package com.divyendu;

import java.util.Observer;

import com.divyendu.observers.CurrentConditions;
import com.divyendu.observers.HeatIndex;
import com.divyendu.subject.WeatherData;

public class WeatherApp {

	public static void main(String[] args) {
		//create weatherdata instance/subject instance
		WeatherData weatherObject = new WeatherData();
		
		//create the observer instances 
		Observer cc_displayObject = new CurrentConditions(weatherObject);
		Observer hi_displayObject = new HeatIndex(weatherObject);
		
		//some changes have taken place, so update all displays
		weatherObject.setMeasurements(50.5F, 20.1F, 12.6F);
		System.out.println("***************************************************");
		//changes have taken place again, so updating
		weatherObject.setMeasurements(10.5F, 70.1F, 22.6F);
		
		
		
		

	}

}
