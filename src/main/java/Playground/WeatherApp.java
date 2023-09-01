package Playground;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

// Subject-Klasse für die Datenwerte
class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;
    private PropertyChangeListener listener;

    public void setPropertyChangeListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        if (listener != null) {
            PropertyChangeEvent event = new PropertyChangeEvent(this, "measurementsChanged", null, null);
            listener.propertyChange(event);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }
}

// Observer-Klasse für die GUI
class WeatherDisplay extends JPanel implements PropertyChangeListener {
    private WeatherData weatherData;
    private JLabel temperatureLabel;
    private JLabel humidityLabel;
    private JLabel pressureLabel;

    public WeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.setPropertyChangeListener(this);

        temperatureLabel = new JLabel("Temperatur: ");
        humidityLabel = new JLabel("Luftfeuchtigkeit: ");
        pressureLabel = new JLabel("Luftdruck: ");

        setLayout(new GridLayout(3, 2));
        add(temperatureLabel);
        add(humidityLabel);
        add(pressureLabel);

        updateLabels();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurementsChanged".equals(evt.getPropertyName())) {
            updateLabels();
        }
    }

    private void updateLabels() {
        double temperature = weatherData.getTemperature();
        double humidity = weatherData.getHumidity();
        double pressure = weatherData.getPressure();

        temperatureLabel.setText("Temperatur: " + temperature + " °C");
        humidityLabel.setText("Luftfeuchtigkeit: " + humidity + " %");
        pressureLabel.setText("Luftdruck: " + pressure + " hPa");
    }
}

public class WeatherApp {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherData);

        JFrame frame = new JFrame("Wetterstation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.add(weatherDisplay);

        JButton generateButton = new JButton("Neue Werte generieren");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulierte neue Werte
                java.util.Random random = new java.util.Random();
                double temperature = random.nextDouble() * 30; // Temperatur zwischen 0 und 30 Grad Celsius
                double humidity = random.nextDouble() * 100; // Luftfeuchtigkeit zwischen 0% und 100%
                double pressure = random.nextDouble() * 1000; // Luftdruck zwischen 0 und 1000 hPa

                weatherData.setMeasurements(temperature, humidity, pressure);
            }
        });

        frame.add(generateButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
