package LegoBeispiel;

public class Legostein {
    private String farbe;
    private int groesse;
    private double preis;

    public Legostein(String farbe, int groesse, double preis) {
        this.farbe = farbe;
        this.groesse = groesse;
        this.preis = preis;
    }

    public double getPreis() {
        return preis;
    }

    public String getFarbe() {
        return this.farbe;
    }

    public int getGroesse() {
        return this.groesse;
    }
}
