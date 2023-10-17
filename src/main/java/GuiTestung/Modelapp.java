package GuiTestung;

public class Modelapp extends Subject{
    
    private static int nextID = 0;

    public static int getNextID(){
        int tmp = Modelapp.nextID;
        Modelapp.nextID++;
        return tmp;
        
    }

    private int id;
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
        notifyObserver();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyObserver();
    }


    private String name;
    

    public Modelapp(int id, String name){
        setId(id);
        setName(name);
        
    }

    



}
