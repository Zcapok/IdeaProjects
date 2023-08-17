package J03;
import java.util.Scanner;

import javax.management.remote.rmi.RMIServerImpl_Stub;

public class J04a_Dreieck {

	public static void main(String[] args) {
		String inp_string = "";
		double [] l_zahlen = new double[10];
		double ergebnis = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte länge a,b,c eingeben");
		inp_string = input.nextLine(); 
		
		String[] arrayString = inp_string.split("/");
		
		for (int i = 0 ; i < arrayString.length ; i++) {
		l_zahlen[i] = Double.parseDouble(arrayString[i]);
		if (i >= 3) {
			break;
		}
		System.out.println(l_zahlen[i]);
		}
		
		if(l_zahlen[0] + l_zahlen[1] > l_zahlen[2] && l_zahlen[0] + l_zahlen[2] > l_zahlen[1] && l_zahlen[1] + l_zahlen[2] > l_zahlen[0]) {
			
			System.out.println("Ein Dreieck mit 3 gleich großen Seiten ist immer konstruierbar ");
		}
		else{
			System.out.println("Ein Dreieck mit a= " + l_zahlen[0] + " ,b= " + l_zahlen[1] + " ,c= " + l_zahlen[2] + " ist nicht Kontruierbar" ); 
		}
		
		
		
	}

}
