package DesignPattern.Compositum;

public class Kreis extends Figur2D  {
    private double radius;


    public Kreis( double radius ){
        this.radius = radius;
    }


    @Override
    public double flaeche() {
        double f;
        return f = Math.PI * (Math.pow(this.radius, this.radius));
    }


    @Override
    public double umfang() {
        double u;
        return u = 2 * Math.PI * this.radius;
    }

}
