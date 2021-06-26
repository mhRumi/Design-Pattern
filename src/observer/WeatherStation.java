package observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeaseurements(80, 65, 30.4f);
        weatherData.setMeaseurements(80, 70, 29.2f);
        weatherData.setMeaseurements(70, 45, 40.4f);
    }
}
