package LS01;

import java.text.BreakIterator;
import java.util.Scanner;
public class LS01_Fibonacci {
    
    public static void getFiboonacci(int quantity,int first, int second){
        int firstNumber = first;
        int secondNumber = second;
        int temp = quantity;
        int ergebnis;

        if (firstNumber == 0){
        System.out.print(firstNumber +" " + 1 + " ");
        secondNumber++;
        }
        if(temp >= 0){
           ergebnis = firstNumber + secondNumber;
           firstNumber = secondNumber;
           secondNumber = ergebnis;   
           System.out.print(ergebnis + " ");
           
        }
        else{
            return;
        }
     temp--;
        
       getFiboonacci(temp,firstNumber,ergebnis);

    }

    public static int myIntput(String Text){
        Scanner input = new Scanner(System.in);
        System.out.println(Text);
        int anzahl = input.nextInt();
        
        return anzahl;
    }

    public static int getFactorial(int factorial){
        int ergebnis = 0;
        int tmp = 0;
        int counter = factorial - 1  ;
        if (factorial <=0){
            return counter;
        }
        ergebnis = factorial * counter;
        for (int i = 0 ; i <= factorial ; i++){
            counter--;
            if(counter == 0){
                break;
            }
            
            tmp = ergebnis * counter;
            ergebnis = tmp;
            
            
        }
        System.out.println(ergebnis);
        return ergebnis;
                
    }
        public static void main(String[] args) {
        getFactorial(myIntput("Welche Fakultät ?"));
        getFiboonacci(myIntput("Wieviele Fibonacci durchläufe sollen es werden"),0,0);
    }

}
