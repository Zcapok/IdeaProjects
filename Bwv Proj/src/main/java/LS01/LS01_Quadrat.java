package LS01;

import java.util.Scanner;

public class LS01_Quadrat {

	public static void main(String[] args) {

		// Declaration
		int size = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Seitenlänge des Quadrats eingeben");
		size = input.nextInt() - 1 ;
		// x == 0 fill first row , x == size will fill last row
		// y == 0 will always fill zero position with 1 Star and y == size will fill last position with 1 Star
		for (int x = 0; x <= size; x++) {
			for (int y = 0; y <= size; y++) {
				if (x == 0 || x == size || y == 0 || y == size) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			// At the End of each Loop x  -> nextline
			System.out.print("\n");

		}
	}
}