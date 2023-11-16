package DesignPattern.MVCStudent;

import java.util.Timer;

public class MVCMain {
    public static void main(String[] args) 
    {
        Student model  = retriveStudentFromDatabase();
 
        StudentView view = new StudentView();
 
        StudentController controller = new StudentController(model, view);
  
        controller.setStudentName("Vikram Sharma");
        view.update("Stan", "0324832");
        Timer task = new Timer();
        try {
			task.wait(1000);
			view.update("Barbaran", "0324832");
			task.cancel();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
 
        
    }
 
    private static Student retriveStudentFromDatabase()
    {
        Student student = new Student();
        student.setName("Lokesh Sharma");
        student.setRollNo("15UCS157");
        return student;
    }
}
