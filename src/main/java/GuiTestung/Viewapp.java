package GuiTestung;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Viewapp extends JFrame implements Observer {

    Modelapp model;
    JLabel label;
    public Viewapp(Modelapp model){
        this.model = model;
        init();
        this.setVisible(true);
    }


    public void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        // JLabel
        label = new JLabel("ich bin ein Label");
        // neues Panel
        JPanel panel = new JPanel(new BorderLayout(10, 10) );
       
        // neuer Button
        JButton b1 = new JButton("Button1");
        JButton b2 = new JButton("Button2");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setText("Funktioniert");
                }
            });

        b2.addActionListener((event)-> {
            label.setText("Funktioniert");
            model.setName("Hans-Peter");
        });    

        panel.add(b1,BorderLayout.EAST);
        panel.add(b2,BorderLayout.WEST);
        panel.add(label,BorderLayout.SOUTH);

        this.add(panel,BorderLayout.NORTH);
        
        //this.setVisible(true);

    }


    @Override
    public void update() {
       int id = this.model.getId();
       String name = this.model.getName();
       label.setText(id + " " + name);
    }


}
