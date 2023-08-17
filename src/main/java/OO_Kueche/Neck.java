package OO_Kueche;

public class Neck extends Figur2d {

	private int seitenLaenge;
	private int anzahlEcken;

	
		public Neck(int id, String name, int seitenLaenge, int anzahlEcken) {
		super(id, name);
		setAnzahlEcken(anzahlEcken);
		setSeitenLaenge(seitenLaenge);
	}

		
		@Override
		public double berechneUmfang() {
			return getSeitenLaenge() * getAnzahlEcken();
		}

		public double berechneInnenkreisradius() {
			double zwischenergebnis2 = berechneCot();
			double zwischenergebnis3 = 2 * zwischenergebnis2;
			return getSeitenLaenge() / zwischenergebnis3;
		}

		public double berechneCot() {
			return Math.tan(Math.PI / getAnzahlEcken());
		}

		public int getAnzahlEcken() {
			return anzahlEcken;
		}

		public void setAnzahlEcken(int anzahlEcken) {
			this.anzahlEcken = anzahlEcken;
		}

		public int getSeitenLaenge() {
			return seitenLaenge;
		}

		public void setSeitenLaenge(int seitenLaenge) {
			this.seitenLaenge = seitenLaenge;
		}

		@Override
		public double berechneFläche() {
			return (getAnzahlEcken() / 2) * getSeitenLaenge() * berechneInnenkreisradius() + 0.3; //TODO :)
		}

	}

	

