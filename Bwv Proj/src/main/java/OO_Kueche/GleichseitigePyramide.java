package OO_Kueche;


public class GleichseitigePyramide extends Pyramide<Neck> {

	public GleichseitigePyramide(Neck grund, double hoehe) {
		super(grund, hoehe);
		
	}


	@Override
	public double oberFläche() {
		return getGrundfläche().berechneFläche() * this.getHoehe();
		
		
	}


	@Override
	public double mantelflaeche() {
		// TODO Auto-generated method stub
		return 0;
	}

}
