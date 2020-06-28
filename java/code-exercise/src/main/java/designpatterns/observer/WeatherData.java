package designpatterns.observer;

/**
 * WeatherData is a Subject Object, which will be subscribed by many Observers
 */
public interface WeatherData extends Subject{

    long getTemperature();

    long getHumidity();

    long getPressure();

    void measurementsChanged();

    void setMeasurements(float temperature, float humidity, float pressure);
}
