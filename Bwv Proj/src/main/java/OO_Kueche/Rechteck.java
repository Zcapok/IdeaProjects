package OO_Kueche;

public class Rechteck extends Figur2d {

	private double seiteA;
	private double seiteB;
	
	
	public Rechteck(int id, String name, double seiteA, double seiteB) {
		super(id,name);
		setSeiteA(seiteA);
		setSeiteB(seiteB);
	}
	
	public double getSeiteA() {
		return seiteA;
	}
	public void setSeiteA(double seiteA) {
		this.seiteA = seiteA;
	}
	public double getSeiteB() {
		return seiteB;
	}
	public void setSeiteB(double seiteB) {
		this.seiteB = seiteB;
	}
	
	protected void setID(int id) {
		
	}
	@Override
	public double berechneFläche() throws IllegalArgumentException {
		if ( isValid(getSeiteA(), getSeiteB()) == true) {
		
		double fläche = getSeiteA() * getSeiteB();
		return fläche;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double berechneUmfang() {
		double umfang = (2 * getSeiteA()) + (2 * getSeiteB());
		return umfang;
	}
	public String toString() {

		return super.toString() + " fläche " + berechneFläche() + " Umfang " + berechneUmfang() ;
		
		}
	
	protected static boolean isValid(double seiteA, double seiteB) {
				if( seiteA < 0 || seiteB < 0) {
					return false;
				}
		return true;
	}
	
}
