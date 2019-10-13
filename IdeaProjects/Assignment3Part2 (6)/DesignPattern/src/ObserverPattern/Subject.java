package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2018-12-04.
 */
public class Subject implements ISubject {
    private List<Observer> observers;
    private String flag = "";

    public Subject() {
        observers = new ArrayList<>();
    }

    public String getFlag() {
        return flag;
    }

    public void setChange(String news) {
        flag = news;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observers) {
            observer.update();
        }
    }

}
