package J03;
import java.util.Scanner;

public class J03_Parallelschaltung {

	public static double methWiederstand(double r1, double r2) {
		double var_rges;
		return var_rges = (r1 * r2) / (r1 + r2);
		
	}
	
	public static void main(String[] args) {
		int var_r1,var_r2;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte ersten Wiederstand eingeben");
		var_r1 = input.nextInt();
		System.out.println("Bitte zweiten wiederstand eingeben");
		var_r2 = input.nextInt();
				
		System.out.println("Gesamtwiederstand " + methWiederstand(var_r1, var_r2));
	}

}
