package OO_Kueche;

public abstract class Pyramide <T extends Figur2d> extends Figur3d {

	private double hoehe;
	
	private T grundfläche;

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public T getGrundfläche() {
		return grundfläche;
	}

	public void setGrundfläche(T grundfläche) {
		this.grundfläche = grundfläche;
	}
	
	public Pyramide(T grund, double hoehe) {
		super();
		setGrundfläche(grund);
		setHoehe(hoehe);
	}
	public Pyramide() {
		
	}
	
	public abstract double mantelflaeche();
	
	
	// VPy=1/3⋅G⋅h.
	public double volumen() {
		return (double)(1/3) * getGrundfläche().berechneFläche() * getHoehe();
		
	}
	
	
	@Override
	public double oberFläche() {
		
		return 1;
	}

	
}
