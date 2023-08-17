package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class WetterDaten extends Subject{

    private float temperatur;
    private float feuchtigkeit;
    private float luftdruck;

    public WetterDaten(int t, int f, int l) {
        this.setMesswerte(t, f, l);

    }

    public void setMesswerte(float temp, float feucht, float luft){
        this.temperatur = temp;
        this.feuchtigkeit = feucht;
        this.luftdruck = luft;
        notifyObservers();
    }

    public void setTemperatur(float temparatur) {
        this.temperatur = temparatur;
        this.notifyObservers();
    }

    public void setFeuchtigkeit(float feuchtigkeit) {
        this.feuchtigkeit = feuchtigkeit;
        this.notifyObservers();
    }

    public void setLuftdruck(float luftdruck) {
        this.luftdruck = luftdruck;
        this.notifyObservers();
    }

    public float getFeuchtigkeit() {
        return feuchtigkeit;
    }

    public float getTemperatur() {
        return temperatur;
    }

    public float getLuftdruck() {
        return luftdruck;
    }

    @Override
    public String toString() {
        String line = "Temperatur " + getTemperatur() + "\n" + "Feuchtigkeit " + getFeuchtigkeit() + "\n" + "Luftdruck " + getLuftdruck();
        return line;
    }
}