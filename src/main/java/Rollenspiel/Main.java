package Rollenspiel;

public class Main {
    
    public static void main(String[] args){

            Spielfigur mage = new Magier();
           
            mage.setCurrentweapon(new Messer());
            
            mage.getCurrentweapon().useWeapon();
            
            mage.setCurrentweapon(new Schwert(){
                public void useWeapon(){
                        System.out.println("Ich überschreibe das");
                }
            });
            mage.getCurrentweapon().useWeapon();
           
            
    }
}
