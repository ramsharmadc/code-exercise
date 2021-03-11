package designpatterns.observer;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherDataImpl();

        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ThirdPartyDisplay thirdPartyDisplay = new ThirdPartyDisplay(weatherData);

        weatherData.setMeasurements(85, 72, 69);
        weatherData.setMeasurements(34, 89, 70);
        weatherData.setMeasurements(78, 72, 56);

    }
}
