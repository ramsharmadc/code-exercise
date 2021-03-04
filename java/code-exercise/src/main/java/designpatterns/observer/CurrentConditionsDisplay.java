package designpatterns.observer;

public class CurrentConditionsDisplay implements DisplayElement {

    private final Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: Temperature " + temperature + " degrees, Humidity "
                + humidity + ", Pressure " + pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }
}
