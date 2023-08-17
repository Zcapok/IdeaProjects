package J03;

import java.util.Scanner;

public class J03_Vorname {

	public static String myName(String x) {
		String b = "";
		for (int i = x.length(); i > 0; i--) {
			// the length() counts from 1 , but charAt starts at 0 so you must sub - 1 
			b = b + x.charAt(i - 1);

			System.out.print(x.charAt(i - 1) + " ");
		}
		// if the return parameter is x the Name will be spelled forwards
		// if the return parameter is b the Name will be spelled backwards
		return b;
	}

	public static void getName(String x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		String var_eingabe;
		System.out.println("Bitte Namen eingeben");
		Scanner input = new Scanner(System.in);
		var_eingabe = input.nextLine();
		input.close();

		myName(var_eingabe);
		System.out.println();
		// Get the return value from myName method
		getName(myName(var_eingabe));
	}

}
