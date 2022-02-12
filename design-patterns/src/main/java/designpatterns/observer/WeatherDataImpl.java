package designpatterns.observer;

import java.util.ArrayList;

public class WeatherDataImpl implements WeatherData {

    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public long getTemperature() {
        return 0;
    }

    @Override
    public long getHumidity() {
        return 0;
    }

    @Override
    public long getPressure() {
        return 0;
    }

    @Override
    public void measurementsChanged() {
        notifyObservers();
    }

    @Override
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i > 0 && i < observers.size()) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }
}