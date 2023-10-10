package DesignPattern.Compositum;

import java.util.ArrayList;

public class Figur2DKompositum {
    
    private ArrayList<Figur2D> teilfiguren = new ArrayList<>();

    public ArrayList<Figur2D> getTeileliste(){
        return this.teilfiguren;
    }

    public void addTeilfigur(Figur2D teil){
        teilfiguren.add(teil);
    }

    public void getTeilfigur(int i){
        teilfiguren.get(i);
    }

}
