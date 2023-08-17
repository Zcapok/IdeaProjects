package LS01;

import java.util.Scanner;

public class Ls01_Teiler {

	public static void findeTeiler(int x) {
		int tmp = x + 1;
		int[] arr = new int[tmp];
		
		for (int i = x; i > 0; i--) {
			if (x % i == 0) {
				arr[i] = i;
				System.out.print(i + " ");
			}

		}

	}

	public static void main(String[] args) {
		int ganzeZahl = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Bitte eine Ganze Zahl eingeben");
		ganzeZahl = input.nextInt();

		findeTeiler(ganzeZahl);
	}

}
