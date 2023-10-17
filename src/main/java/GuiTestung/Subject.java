package GuiTestung;

import java.util.ArrayList;

public abstract class Subject {
    
    private ArrayList<Observer> observers = new ArrayList<>();


    public void addObserver(Observer o){
        this.observers.add(o);
    }
    public void removeObserver(Observer o){
        this.observers.remove(o);
    }

    public void notifyObserver(){
        for(Observer obs : observers){
            obs.update();
        }
    }

}
