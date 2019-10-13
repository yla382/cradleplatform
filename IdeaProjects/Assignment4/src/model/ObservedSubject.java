package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 7/27/2016.
 */
public class ObservedSubject {
    private CourseDataBase database = new CourseDataBase();
    private List<UIObserver> list = new ArrayList<>();


    public ObservedSubject() throws IOException {
    }
    ///////////////////////////
    public void insert() {
        notifyObservers();
    }

    public void clear() {
        notifyObservers();
    }
    ///////////////////////////

    public CourseDataBase getDataBase() {
        return database;
    }
    public void addObserver(UIObserver observer) {
        list.add(observer);
    }

    public void notifyObservers() {
        for(UIObserver observer: list) {
            observer.stateChanged();
        }
    }
}
