package OO_Kueche;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Figur2d fact1 = new FigurFactory().createFigur(FigurFactory.FigurTyp.KREIS);
		System.out.println(fact1.toString());


		// Berechnung von Kreis und KreisKegel Ergebnis Korrekt!
		Kreis k2 = new Kreis(0001, "Kreis2", 1);
		Kreiskegel kg3 = new Kreiskegel(k2, 2);
		System.out.println("--------------------------------------------");
		System.out.println("KreisKegel ");
		System.out.println("Fläche     : " + k2.berechneFläche());
		System.out.println("Umfang 	   : " + k2.berechneUmfang());
		System.out.println("Oberfläche : " + kg3.oberFläche());
		
		System.out.println("--------------------------------------------");
		// Berechnung Kugel
		Kugel Kug1 = new Kugel();
		Kug1.setRadius(2);
		System.out.println("Kugel");
		System.out.println("Volumen    : " + Kug1.volumen());
		System.out.println("Oberfläche : " + Kug1.oberFläche());
		System.out.println("--------------------------------------------");
		// Berrechnung von Neck und Gleichseitiger Pyramide Ergebnis Ungewiss !
		Neck n1 = new Neck(0100, "Neck1", 5, 4);
		GleichseitigePyramide g1 = new GleichseitigePyramide(n1, 5);
		System.out.println("Gleichseitige Pyramide");
		System.out.println("Fläche     : " + n1.berechneFläche());
		System.out.println("Umfang     : " + n1.berechneUmfang());
		System.out.println("Oberfläche : " + g1.oberFläche());
		System.out.println("--------------------------------------------");
		// Berechnung Gerades Prisma
		Dreieck d_eck = new Dreieck(0020, "Dreieck" , 4, 6, 5); 
		System.out.println("Dreieck : ");
		System.out.println("Fäche   : " + d_eck.berechneFläche() );
		System.out.println("Umfang  : " + d_eck.berechneUmfang() );
		
		if (d_eck.isValid(4, 5, 6) == true){
			GeradesPrisma prism = new GeradesPrisma(d_eck, 6);
			System.out.println("--------------------------------------------");
			System.out.println("Prisma     : " );
			System.out.println("Volumen    : " + prism.volumen());
			System.out.println("Oberfläche : " + prism.oberFläche());
			
			
		}
		
		ArrayList<String> myStringArray = new ArrayList<>();
		myStringArray.add(k2.toString());
		myStringArray.add(Kug1.toString());

		WriteToFile toFile = new WriteToFile();
		toFile.inputWriter(myStringArray);

	}

}
