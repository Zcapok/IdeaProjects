package J03;
import java.time.temporal.ValueRange;
import java.util.Scanner;

public class J03_Rechenarten {

	public static double grundMethod(double x , double y) {
		// addieren
		double var_ergebnis = x + y;
		System.out.println("Addition " +var_ergebnis);
		// subtrahieren
		var_ergebnis = x - y;
		System.out.println("Subtraktion " + var_ergebnis);
		// Multiplizieren
		var_ergebnis = x * y;
		System.out.println("Multiplikation " + var_ergebnis);
		// Dividieren
		var_ergebnis = x / y;
		System.out.println("Division " + var_ergebnis);
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte erste Zahl eingeben");
		int var_zahl_1 = input.nextInt();
		System.out.println("Bitte zweite Zahl eingeben");
		int var_zahl_2 = input.nextInt();
		
		grundMethod(var_zahl_1, var_zahl_2);
		

	}

}
