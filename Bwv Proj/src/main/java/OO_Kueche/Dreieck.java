package OO_Kueche;

public class Dreieck extends Figur2d {
	private double seiteA;
	private double seiteB;

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

	public double getSeiteC() {
		return seiteC;
	}

	public void setSeiteC(double seiteC) {
		this.seiteC = seiteC;
	}

	private double seiteC;

	public Dreieck(int id, String name, double seiteA, double seiteB, double seiteC) {
		super(id, name);
		setSeiteA(seiteA);
		setSeiteB(seiteB);
		setSeiteC(seiteC);

	}

	@Override
	public double berechneFläche() throws IllegalArgumentException {
		if (isValid(seiteA, seiteB, seiteC) == false) {
			throw new IllegalArgumentException();
		}
		
		double U = berechneUmfang() * 0.5;
		double flaeche = Math.sqrt(U * (U - seiteA) * (U - seiteB) * (U - seiteC));
		return flaeche;
	}

	@Override
	public double berechneUmfang() throws IllegalArgumentException {
		if (isValid(seiteA, seiteB, seiteC) == false) {
			throw new IllegalArgumentException();
		}

		double umfang = (getSeiteA() + getSeiteB() + getSeiteC());
		return umfang;
	}

	public String toString() {

		return super.toString() + " fläche " + berechneFläche() + " Umfang " + berechneUmfang();

	}

	protected static boolean isValid(double seiteA, double seiteB, double seiteC) {

		if (seiteA <= 0 || seiteB <= 0 || seiteC <= 0) {

			return false;
		}
		// A ist die Größte Seite , dann müssen B und C >= A sein
		if (seiteA > seiteB && seiteA > seiteC) {
			if (seiteB + seiteC >= seiteA) {
				return true;
			} else {
				return false;
			}
		}

		// B ist die Größte Seite , dann müssen A und C >= B sein
		if (seiteB > seiteA && seiteB > seiteC) {
			if (seiteC + seiteA >= seiteB) {
				return true;
			} else {
				return false;
			}
		}

		// C ist die Größte Seite , dann müssen A und B >= C sein
		if (seiteC > seiteA && seiteC > seiteB) {
			if (seiteB + seiteA >= seiteC) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

}
