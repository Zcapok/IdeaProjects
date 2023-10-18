package DesignPattern.MVCStudent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentView extends JFrame implements Observer  {
	
	private String studentName;
	
	
	JFrame frame = new JFrame("Gui für Studenten");
	
	JPanel panel = new JPanel(new FlowLayout());
	JPanel panel2 = new JPanel(new BorderLayout(5,5));
	
	
	JButton b1 = new JButton("Button 1");
	JButton b2 = new JButton("Button 2");
	JButton b3 = new JButton("Studenten Anzeigen");
	JLabel l1 = new JLabel("Hallo ich bin ein Label");
	JLabel labelStudent = new JLabel();
	
    public void printStudentDetails(String studentName, String studentRollNo)
    {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
        this.studentName = studentName;
        initGui();
    }

    @Override
    public void update(String name, String rolNo) {
        printStudentDetails(name, rolNo);
        
    }
    
    public void initGui() {
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setSize(800, 800);
    	
    	b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setText("Klick");
				
			}
		});
    	
    	
    	b2.addActionListener(e -> b1.setText("Button 1") );
    	
    	b3.addActionListener(e-> labelStudent.setText(this.studentName));
    	
    	
    	panel.add(b1);
    	panel.add(b2);
    	panel.add(b3);
    	panel.add(l1);
    	panel.add(labelStudent);
    	panel.setVisible(true); 
    	//panel2.add(l1);
    	//panel2.setVisible(true);
    	frame.add(panel);
    	//frame.add(panel2);
    	frame.setVisible(true);
    	
    	
    	
    }
    
}
