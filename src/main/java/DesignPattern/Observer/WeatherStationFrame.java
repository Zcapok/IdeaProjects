package DesignPattern.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherStationFrame extends JFrame {
    private JButton generateButton;

    public WeatherStationFrame(String title, ActionListener buttonListener) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        generateButton = new JButton("Neue Wetterdaten generieren");
        generateButton.addActionListener(buttonListener);
        
        setLayout(new FlowLayout());
        add(generateButton);
        
        pack();
        setVisible(true);
    }
}
