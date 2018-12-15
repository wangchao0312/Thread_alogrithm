package Head_First;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData(){
        observers=new ArrayList<>();
    }

    //注册观察者
    public void registerObserver(Observer o){
        observers.add(o);
    }

    //清除观察者
    public void removeObserver(Observer o){
        int i=observers.indexOf(o);
        if(i>0)
            observers.remove(i);
    }
    //通知观察者！！
    public void notifyObservers(){
        for(int i=0;i<observers.size();i++)
        {
            Observer observer=observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

}
