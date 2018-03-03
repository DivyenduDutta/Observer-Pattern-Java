package com.divyendu.observers;

import java.util.Observable;
import java.util.Observer;

import com.divyendu.subject.WeatherData;

public class CurrentConditions implements Observer {

	public CurrentConditions(Observable subjectObject) {
		subjectObject.addObserver(this);
	}
	
	public void display(float temp,float humidity,float b_pressure){
		System.out.println("temperature is "+temp+" degree celsius");
		System.out.println("humidity is "+humidity);
		System.out.println("barometric pressure is "+b_pressure+" pascal");
		
		System.out.println("***************************************************");
	}

	@Override
	public void update(Observable weatherDataSubject, Object arg) {
		if(arg != null){
			//push implementation code
		}
		else{
			//pull implementation code
			if(weatherDataSubject instanceof WeatherData){
				WeatherData weatherDataObject = (WeatherData)weatherDataSubject;
				float temp = weatherDataObject.getTemperature();
				float humidity = weatherDataObject.getHumidity();
				float b_pressure = weatherDataObject.getBarometricPressure();
				
				display(temp,humidity,b_pressure);
			}
			
		}

	}

}
