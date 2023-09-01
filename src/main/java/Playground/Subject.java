package Playground;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    
    private List<Observer> observerList = new ArrayList<>();

    public void registerObserver(Observer observer){
        observerList.add(observer);
    }
    
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){

            for(Observer obs : observerList){
                obs.update();
            }
    }

}
