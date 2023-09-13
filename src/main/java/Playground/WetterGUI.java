package Playground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WetterGUI extends JFrame implements ActionListener{

//private WetterDaten daten;
private Timer timer;

private JFrame frame = new JFrame();
private JLabel labelTemp = new JLabel();
private JLabel labelFeucht = new JLabel();
private JLabel labelDruck = new JLabel();
private JLabel labelUPTemp = new JLabel();
private JLabel labelUPFeucht = new JLabel();
private JLabel labelUPDruck = new JLabel();
//private JPanel panel = new JPanel();
private String[] column = {"Temperatur", "Feuchtigkeit", "Luftdruck" };
private String[][] data ;

private JButton b1;

public WetterGUI(WetterDaten daten){
   initComponets();
   //updateLabel(daten);
}

public void initComponets(){
    labelTemp.setText("Temperatur");
    labelFeucht.setText("Feuchtigkeit");
    labelDruck.setText("Luftdruck");
    labelTemp.setBounds(10, 10, 120, 120);
    labelUPTemp.setBounds(100, 10, 120, 120);

    labelFeucht.setBounds(10, 80, 120 ,120);
    labelUPFeucht.setBounds(100, 80, 120, 120);

    labelDruck.setBounds(10, 140, 120, 120);
    labelUPDruck.setBounds(100, 140, 120, 120);

    // Table
    
    JTable table = new JTable(data, column);

    //Button

    b1 = new JButton("Klick mich");
    b1.setBounds(10, 400, 100,100);
    b1.setVisible(true);
    b1.addActionListener(this);
    
    timer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            b1.setText("Klick mich");
            timer.stop();
        }
    });
    
    //Frame
    frame.setTitle("WetterGUI");
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(800, 600);    
    frame.add(labelTemp);
    frame.add(labelUPTemp);
    frame.add(labelFeucht);
    frame.add(labelUPFeucht);
    frame.add(labelDruck);
    frame.add(labelUPDruck);
    frame.add(b1);
    frame.setLayout(null);
    
    frame.setVisible(true);
}
public void updateTable(WetterDaten daten){
    
}


public void updateLabel(WetterDaten daten){
    labelUPTemp.setText(""+daten.getTemperatur());
    labelUPFeucht.setText(""+daten.getFeuchtigkeit());
    labelUPDruck.setText(""+ daten.getLuftdruck());
    
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        b1.setText("Nochmal geklickt");
        timer.start();
    }
   }
    //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}



