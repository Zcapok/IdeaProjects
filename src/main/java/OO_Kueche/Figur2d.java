package OO_Kueche;

import java.util.ArrayList;

public abstract class Figur2d  {

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = Math.abs(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Figur2d(int id, String name) {
        setId(id);
        setName(name);
    }

    public abstract double berechneFläche();

    public abstract double berechneUmfang();

    public String toString() {

        return "| ID: " + getId() + " | Name: " + getName();

    }



}
