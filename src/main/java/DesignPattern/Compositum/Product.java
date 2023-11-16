package DesignPattern.Compositum;

public abstract class Product implements Box {
    
    private String title;
    private double price;

    public Product(String title, double price){
        setTitle(title);
        setPrice(price);
        
    }

    public void setTitle(String title){
       this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
