package com.divyendu.subject;

import java.util.Observable;

public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float barometricPressure;
	@Override
	public String toString() {
		return "WeatherData [temperature=" + temperature + ", humidity=" + humidity + ", barometricPressure="
				+ barometricPressure + "]";
	}
	public WeatherData() {
		super();
	}
	
	//getters and setters for all the states in the weather data subject
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getBarometricPressure() {
		return barometricPressure;
	}
	public void setBarometricPressure(float barometricPressure) {
		this.barometricPressure = barometricPressure;
	}
	
	private void measurementsChanged(){
		setChanged(); // sets the inbuilt changed variable to TRUE
		//call update method of all the subscribed observers
		//this is the pull implementation of the Observer pattern
		notifyObservers();
		
		/*so notifyObservers() calls the update() of all the observers but it does it in the opposite direction ie, the observer who
		subscibed last/latest, its update method is called fisrt.*/
	}
	
	public void setMeasurements(float temp, float humidity, float b_pressure){
		this.temperature = temp;
		this.humidity = humidity;
		this.barometricPressure = b_pressure;
		
		measurementsChanged();
	}

}
