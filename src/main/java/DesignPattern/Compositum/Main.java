package DesignPattern.Compositum;

public class Main {
    
    public static void main(String[] args){

        Box box1 = new VideoGame("1", 100);
        Box box2 = new Book("Hamlet", 10);

        CompositeBox listprice = new CompositeBox(box1,box2);
        System.out.println(listprice.calculatePrice());

    }
}
