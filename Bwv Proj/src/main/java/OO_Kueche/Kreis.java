package OO_Kueche;

public class Kreis extends Figur2d {
    private double radius;


    public Kreis(int id, String name, double radius) {
        super(id, name);

        setRadius(radius);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    // A = pi * r^2
    @Override
    public double berechneFläche() {

        return Math.PI * (radius * radius);
    }

    // umfang = 2 * pi * r
    @Override
    public double berechneUmfang() {

        return 2 * Math.PI * radius;
    }

    public String toString() {

        return super.toString() + " fläche " + berechneFläche() + " Umfang " + berechneUmfang();

    }


}
