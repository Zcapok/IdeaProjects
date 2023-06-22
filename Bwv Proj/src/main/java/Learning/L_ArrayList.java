package Learning;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class L_ArrayList {

    public void L_ArrayList(){

    }

    public void testArrayList_output(ArrayList<String> arrayL){
        // Durchläuft die mitgegebene Liste
        for (String m : arrayL){
            System.out.println(m.toString());
        }

    }


    public void testArray_output(String[] array){

        String[] string = array;

        for (String m: string) {
            System.out.println(m.toString());
        }


    }

}
