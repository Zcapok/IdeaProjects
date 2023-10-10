package DesignPattern.Compositum;

public class Rechteck extends Figur2D {
    private double hoehe;
    private double breite;

    public Rechteck(double h , double b){
        this.hoehe = h;
        this.breite = b;

    }

    @Override
    public double flaeche() {
        double f;
        return f = this.hoehe * this.breite;
    }

    @Override
    public double umfang() {
       double u;
       return u = (2*this.hoehe) + (2*this.breite);
    }

}
