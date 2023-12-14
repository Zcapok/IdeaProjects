package Rollenspiel;

public class Magier extends Spielfigur{

    @Override
    public void fight() {
        getCurrentweapon().useWeapon();
        
        System.out.println("Ich bekomme die Info für die Waffe und Kämpfe damit");
    }
    
}
