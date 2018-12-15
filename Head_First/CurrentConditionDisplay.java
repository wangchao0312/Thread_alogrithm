package Head_First;

public class CurrentConditionDisplay implements DisplayElement,Observer{

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }

    public void display(){
        System.out.println("Tempature is "+temperature+" humidity is "+humidity+"pressure is "+pressure);
    }
}
