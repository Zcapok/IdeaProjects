package GuiTestung;

public class Controllerapp {
    
    Modelapp model;
    Viewapp view;

    public Controllerapp(Modelapp model, Viewapp view){
        this.model = model;
        this.view = view;
    }

    public void addObserver(Observer observer) {
        model.addObserver(observer);
    }




}
