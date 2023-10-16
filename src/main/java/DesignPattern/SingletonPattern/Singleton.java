package DesignPattern.SingletonPattern;

public final class Singleton {

    private static Singleton instanz = new Singleton();

    private Singleton(){}

    public static Singleton getInstanz(){

        return instanz;
    }

}
