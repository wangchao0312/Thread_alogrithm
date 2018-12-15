package Head_First;

public class Test_Observer {
    public static void main(String[] args){
        WeatherData weatherData=new WeatherData();
        CurrentConditionDisplay currentDisplay=new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(1,2,3);
    }
}
