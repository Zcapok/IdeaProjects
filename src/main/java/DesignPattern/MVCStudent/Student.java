package DesignPattern.MVCStudent;

public class Student extends Subject {
    private String rollNo;
    private String name;
    
    public String getRollNo() 
    {
        return rollNo;
    }
    
    public void setRollNo(String rollNo) 
    {
        this.rollNo = rollNo;
        notifyObservers(name, rollNo);
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
        notifyObservers(name, rollNo);
    }
}
