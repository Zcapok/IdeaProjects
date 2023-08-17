package OO_Kueche;

public class Kreiskegel extends Pyramide<Kreis>{

	public Kreiskegel(Kreis grund, double hoehe) {
		super(grund, hoehe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double oberFläche() {
		// Oberfläche = Grundfläche + Mantelfläche
		/* O = r^2 * pi + r * pi * s
		 * 
		 * Mantelinie s = Wurzel(r^2 + h^2)
		 */
		double s = getGrundfläche().berechneFläche();
		// Aus der Fläche den radius wieder bekommen
		s = Math.sqrt(s / Math.PI);
		double radius = s;
		
		double mantellinie = Math.sqrt((radius * radius) + (getHoehe() * getHoehe()));
		double oberflaeche = (Math.pow(radius, radius) * Math.PI) + (radius * Math.PI * mantellinie);
		
		
		return oberflaeche ;
	}

	@Override
	public double mantelflaeche() {
		// TODO Auto-generated method stub
		return 0;
	}

}
