import java.util.ArrayList;

interface IObservable {
    void add(IObserver ob);
    void remove(IObserver ob);
    void notifyObserver();
}

interface IObserver {
    void updateValue();
}

class WeatherStation implements IObservable{

    private ArrayList<IObserver>observers;
    private int temparature;
    private int humidity;
    WeatherStation() {
        observers = new ArrayList<IObserver>();
        temparature = 0;
        humidity = 0;
    }

    @Override
    public void add(IObserver ob) {
        observers.add(ob);
    }

    @Override
    public void remove(IObserver ob) {
        int index = observers.indexOf(ob);
        observers.remove(index);
    }

    @Override
    public void notifyObserver() {
        for(IObserver observer: observers) {
            observer.updateValue();
        }
    }

    public void setTemparature(int newTemp) {
        this.temparature = newTemp;
        notifyObserver();
    }

    public void setHumidity(int newHumidity) {
        this.humidity = newHumidity;
        notifyObserver();
    }

    public int getTemparature() {
        return temparature;
    }

    public int getHumidity() {
        return humidity;
    }
}

class Observer implements IObserver{

    WeatherStation station;

    Observer(WeatherStation station) {
        this.station = station;
        station.add(this);
    }

    @Override
    public void updateValue() {
        System.out.println("New temparature is "+station.getTemparature());
        System.out.println("New Humidity is "+station.getHumidity());
    }
}


public class observerPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer observer = new Observer(station);
        station.setTemparature(10);
        station.setHumidity(15);
        Observer observer2 = new Observer(station);
        station.setTemparature(12);
        station.remove(observer2);
        station.setHumidity(17);
    }
}
