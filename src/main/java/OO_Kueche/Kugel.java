package OO_Kueche;

public class Kugel extends Figur3d {

	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return this.radius;
	}
	
	@Override
	public double oberFläche() {
		
		return 4 * Math.PI * Math.pow(radius, radius);
	}

	@Override
	public double volumen() {
		
		return (4/3.0) * Math.PI * (radius*radius*radius);
	}

}
