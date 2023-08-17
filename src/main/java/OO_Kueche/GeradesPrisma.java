package OO_Kueche;

public class GeradesPrisma <T extends Figur2d > extends Figur3d {
	private double hoehe;
	private T grundflaeche;
	public double getHoehe() {
		return hoehe;
	}
	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	public T getGrundflaeche() {
		return grundflaeche;
	}
	public void setGrundflaeche(T grundflaeche) {
		this.grundflaeche = grundflaeche;
	}
	
	public GeradesPrisma(T grund, double hoehe) {
		setHoehe(hoehe);
		setGrundflaeche(grund);
		
	}


	@Override
	public double oberFläche() {
		
		return (2 * getGrundflaeche().berechneFläche()) + (getGrundflaeche().berechneUmfang() * getHoehe());
	}
	@Override
	public double volumen() {
		
		return getHoehe() * getGrundflaeche().berechneFläche() ;
	}
	

	
	
}
