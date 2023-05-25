package LS01;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LS01_BierTrinken {

	public static int zahlGenerieren() {
		Random rand = ThreadLocalRandom.current();
		int znumber = 1 + rand.nextInt(3);
		return znumber;

	}

	public static void main(String[] args) {
		int zahlG;
		double alkspiegel = 0.00, promille = 0.00;
		Scanner input = new Scanner(System.in);
//		System.out.println("Bitte Zahl zwischen 1 und 3 raten!");
		while (alkspiegel <= 0.8) {
			System.out.println("Bitte Zahl zwischen 1 und 3 raten!");
			zahlG = input.nextInt();
			int tmpG = zahlGenerieren();
			String success = "";
			if (tmpG == zahlG) {
				alkspiegel = alkspiegel - 0.02;
				success = "Erfolg";
			} else {
				alkspiegel = alkspiegel + 0.05;
				success = "Verloren";
			}
			System.out.println("Sie hatten " + success + " und ihr Alkoholspiegel beträgt " + alkspiegel);
		}

	}

}
