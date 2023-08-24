package DesignPattern.Observer;
import javax.swing.*;
import java.awt.*;

public class GuiMain {
    private JFrame frame;
    private JLabel tempdatalabel;
    private JLabel humidydatalabel;
    private JLabel pressuredatalabel;

    public GuiMain(float temp , float humidy, float pressure) {
        frame = new JFrame("Wetterstation GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);
        initGUI(temp,humidy,pressure);
    }

    private void initGUI(float temp, float humidy, float pressure) {
        frame.setLayout(new GridLayout(0,2));

        JLabel temptextlabel = new JLabel("Temperatur ");
        JLabel humidytextlabel = new JLabel("Luftfeuchtigkeit ");
        JLabel pressuretextlabel = new JLabel("Luftdruck ");

        tempdatalabel = new JLabel(String.valueOf(temp));
        humidydatalabel = new JLabel(String.valueOf(humidy));
        pressuredatalabel = new JLabel(String.valueOf(pressure));
        frame.add(temptextlabel);
        frame.add(tempdatalabel);
        frame.add(humidytextlabel);
        frame.add(humidydatalabel);
        frame.add(pressuretextlabel);
        frame.add(pressuredatalabel);
        frame.setVisible(true);

    }

}
