package LS01;

import java.util.Scanner;

public class LS01_Primzahlen {

	public static void main(String[] args) {
		long primZahl = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte Ganze zahl eingeben");
		primZahl = input.nextLong();
		// Loop for primenumber
		for(int i = 2; i < primZahl; i++) {
			// if the number % i has no remainder its not a primenumber and the loop ends direktly with a break
			if(primZahl % i == 0) {
				System.out.println( primZahl + " ist keine Primzahl");
				break;
			}else {
				System.out.println(primZahl + " ist eine Primzahl");
				break;
			}
			
		}
		
	}

}
