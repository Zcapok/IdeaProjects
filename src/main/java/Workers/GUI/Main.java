package Workers.GUI;


import Workers.mitarbeiter.BueroArbeiter;
import Workers.mitarbeiter.Mitarbeiter;

public class Main {
    
    public static void main(String[] args){
        
        Mitarbeiter stan = new BueroArbeiter(1, "Stan", 2000);

        System.out.println(stan);
    }

}
