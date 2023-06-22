package Learning;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String args[]){

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Tom"));
        list.add("Tom");
        list.add("Tam");
        list.add("Tim");
        list.add("Tem");


        String[] testArray = new String[10];

        for (int i=0; i < testArray.length; i++){
            testArray[i] = "Test";
        }


        L_ArrayList myArray= new L_ArrayList();
        myArray.testArray_output(testArray);
        myArray.testArrayList_output(list);

    }


}