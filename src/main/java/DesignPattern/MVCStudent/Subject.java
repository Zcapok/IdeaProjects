package DesignPattern.MVCStudent;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String name, String rollNo) {
        for (Observer observer : observers) {
            observer.update(name, rollNo);
        }
    }
}
