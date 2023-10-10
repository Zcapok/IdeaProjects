package DesignPattern.Compositum;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        //ArrayList<Figur2D> figurliste = new ArrayList<>();

        Figur2D kreis = new Kreis(2);
        Figur2D rechteck = new Rechteck(4,7);



        Figur2DKompositum Kompositumliste = new Figur2DKompositum();
        Kompositumliste.addTeilfigur(rechteck);
        Kompositumliste.addTeilfigur(kreis);
        
        for(Figur2D s : Kompositumliste.getTeileliste()){
            System.out.println(s.flaeche());
        }
    }

}
