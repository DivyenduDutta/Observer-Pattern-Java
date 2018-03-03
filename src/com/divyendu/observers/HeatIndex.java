package com.divyendu.observers;

import java.util.Observable;
import java.util.Observer;

import com.divyendu.subject.WeatherData;

public class HeatIndex implements Observer {
	
	public HeatIndex(Observable subjectObject) {
		subjectObject.addObserver(this);
	}
	
	public void display(float heatIndex){
		System.out.println("The heat index is "+heatIndex);
		
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
				
				float heatIndex = (temp*20)+(humidity*b_pressure);
				
				display(heatIndex);
			}
			
		}

	}

}
