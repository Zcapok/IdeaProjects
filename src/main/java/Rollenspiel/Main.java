package Rollenspiel;

public class Main {
    
    public static void main(String[] args){

            Spielfigur mage = new Magier();
            
            mage.setCurrentweapon(new Messer());
            mage.fight();
            mage.getCurrentweapon().useWeapon();
            
            mage.setCurrentweapon(new Schwert());            
            
            mage.getCurrentweapon().useWeapon();
           
            
    }
}
