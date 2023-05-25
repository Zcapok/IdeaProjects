package J03;
import java.util.Scanner;
public class J03_Benzin {

	public static void verbRechner(double x , double y) {
		
		double var_ergebnis = y / x * 100;
		System.out.println("Durchschnittsverbrauch " + var_ergebnis + "L / 100km");
		
	}
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte gefahrene Km angeben");
		double var_km = input.nextDouble();
		System.out.println("Bitte Verbrauchten Kraftstoff in Liter angeben");
		double var_liter = input.nextDouble();
		
		verbRechner(var_km, var_liter);
		

		int zahl1 =345, zahl2=987, ergebnis = 0;
		char wahl;
		Scanner eingabeTool = new Scanner(System.in);
System.out.println("Summe (+) oder Produkt (*)?");
wahl = eingabeTool.next().charAt(0) ;

if ((wahl == '+') || (wahl == '*'))
	if (wahl == '+')
	 	ergebnis = zahl1 + zahl2;
else
	ergebnis = zahl1 * zahl2;
if (!(wahl == '+' || wahl == '*')) 
	 System.out.println(" Ich rechne nur bei \'+\' oder \'*\'.");

System.out.println("Ergebnis: "  + ergebnis + ".");

	}

}
