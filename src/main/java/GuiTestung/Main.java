package GuiTestung;

public class Main {
    

    public static void main(String[] args){
        
        Modelapp m1 = new Modelapp(1, "Gerd");
        Viewapp v1 = new Viewapp(m1);
        Controllerapp c1 = new Controllerapp(m1, v1);
        
        c1.addObserver(v1);
        
        //m1.addObserver(v1);

    }
}
