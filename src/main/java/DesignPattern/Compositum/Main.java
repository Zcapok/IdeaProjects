package DesignPattern.Compositum;

<<<<<<< HEAD
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

=======
public class Main {
    
    public static void main(String[] args){

        Box box1 = new VideoGame("1", 100);
        Box box2 = new Book("Hamlet", 10);

        CompositeBox listprice = new CompositeBox(box1,box2);
        System.out.println(listprice.calculatePrice());

    }
>>>>>>> 06d928863d004784304f1e26bc25e2865468d880
}
