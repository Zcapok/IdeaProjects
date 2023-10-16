package DesignPattern.SingletonPattern;

public final class Singleton {

    private static Singleton instanz = new Singleton();

<<<<<<< HEAD
    private Singleton(){   
    }
=======
    private Singleton(){}
>>>>>>> 7f64acdb231d5d7758a957e40f5bffb4275d87e1

    public static Singleton getInstanz(){
        
        return instanz;
    }

}
