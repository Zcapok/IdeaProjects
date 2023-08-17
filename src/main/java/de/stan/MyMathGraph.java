package de.stan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Dreieck {
    private int id;
    private double basis;
    private double hoehe;
    private double flaeche;

    public Dreieck(int id, double basis, double hoehe) {
        this.id = id;
        this.basis = basis;
        this.hoehe = hoehe;
        this.flaeche = berechneFlaeche();
    }

    public double berechneFlaeche() {
        return 0.5 * basis * hoehe;
    }

    public void anzeigen() {
        System.out.println("Dreieck " + id + ":");
        System.out.println(" - Basis: " + basis);
        System.out.println(" - Höhe: " + hoehe);
        System.out.println(" - Fläche: " + flaeche);
    }

    public double getFlaeche() {
        return flaeche;
    }

    public int getId() {
        return id;
    }

    public double getHoehe() {
        return this.hoehe;
    }
}

class Rechteck {
    private int id;
    private double laenge;
    private double breite;
    private double flaeche;

    public Rechteck(int id, double laenge, double breite) {
        this.id = id;
        this.laenge = laenge;
        this.breite = breite;
        this.flaeche = berechneFlaeche();
    }

    public double berechneFlaeche() {
        return laenge * breite;
    }

    public void anzeigen() {
        System.out.println("Rechteck " + id + ":");
        System.out.println(" - Länge: " + laenge);
        System.out.println(" - Breite: " + breite);
        System.out.println(" - Fläche: " + flaeche);
    }

    public double getFlaeche() {
        return flaeche;
    }

    public int getId() {
        return id;
    }

    public double getLaenge() {
        return this.laenge;
    }

    public double getBreite() {
        return this.breite;
    }
}

class Figur {
    private List<Dreieck> dreiecke;
    private List<Rechteck> rechtecke;

    public Figur() {
        dreiecke = new ArrayList<>();
        rechtecke = new ArrayList<>();
    }

    public void hinzufuegenDreieck(int id, double basis, double hoehe) {
        Dreieck dreieck = new Dreieck(id, basis, hoehe);
        dreiecke.add(dreieck);
    }

    public void hinzufuegenRechteck(int id, double laenge, double breite) {
        Rechteck rechteck = new Rechteck(id, laenge, breite);
        rechtecke.add(rechteck);
    }

    public List<Dreieck> getDreiecke() {
        return dreiecke;
    }

    public List<Rechteck> getRechtecke() {
        return rechtecke;
    }
}

class ErgebnisFrame extends JFrame {
    private JCheckBox dreieckCheckBox;
    private JCheckBox rechteckCheckBox;

    private Figur figur;
    private List<JLabel> ergebnisLabels;

    public ErgebnisFrame(Figur figur) {
        this.figur = figur;
        this.ergebnisLabels = new ArrayList<>();

        setTitle("Ergebnisse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(figur.getDreiecke().size() + figur.getRechtecke().size() + 1, 1));

        dreieckCheckBox = new JCheckBox("Dreiecke anzeigen", true);
        dreieckCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnzeige();
            }
        });
        add(dreieckCheckBox);

        for (Dreieck dreieck : figur.getDreiecke()) {
            JLabel dreieckLabel = new JLabel("Dreieck " + dreieck.getId() + ": Fläche = " + dreieck.getFlaeche());
            ergebnisLabels.add(dreieckLabel);
            add(dreieckLabel);
        }

        rechteckCheckBox = new JCheckBox("Rechtecke anzeigen", true);
        rechteckCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnzeige();
            }
        });
        add(rechteckCheckBox);

        for (Rechteck rechteck : figur.getRechtecke()) {
            JLabel rechteckLabel = new JLabel("Rechteck " + rechteck.getId() + ": Fläche = " + rechteck.getFlaeche());
            ergebnisLabels.add(rechteckLabel);
            add(rechteckLabel);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateAnzeige() {
        for (JLabel label : ergebnisLabels) {
            label.setVisible(dreieckCheckBox.isSelected() || rechteckCheckBox.isSelected());
        }
    }
}

class GraphFrame extends JFrame {
    private Figur figur;
    private JPanel graphPanel;

    public GraphFrame(Figur figur) {
        this.figur = figur;

        setTitle("Graph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };

        add(graphPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawGraph(Graphics g) {
        int graphWidth = graphPanel.getWidth();
        int graphHeight = graphPanel.getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, graphWidth, graphHeight);

        g.setColor(Color.BLACK);

        // Zeichne Achsen
        g.drawLine(0, graphHeight / 2, graphWidth, graphHeight / 2);
        g.drawLine(graphWidth / 2, 0, graphWidth / 2, graphHeight);

        // Zeichne Dreiecke
        g.setColor(Color.BLUE);
        for (Dreieck dreieck : figur.getDreiecke()) {
            int x = graphWidth / 2 + (int) (dreieck.getFlaeche() * 10);
            int y = graphHeight / 2;
            g.fillOval(x, y, 5, 5);
            g.drawString(String.valueOf(dreieck.getId()), x, y);
        }

        // Zeichne Rechtecke
        g.setColor(Color.RED);
        for (Rechteck rechteck : figur.getRechtecke()) {
            int x = graphWidth / 2 - (int) (rechteck.getFlaeche() * 10);
            int y = graphHeight / 2;
            g.fillRect(x, y, 5, 5);
            g.drawString(String.valueOf(rechteck.getId()), x, y);
        }
        
        // Zeichne Verbindungslinien
        g.setColor(Color.BLACK);
        for (Dreieck dreieck : figur.getDreiecke()) {
            int x = graphWidth / 2 + (int) (dreieck.getFlaeche() * 10);
            int y = graphHeight / 2;
            int[] xPoints = {x, graphWidth / 2, graphWidth / 2};
            int[] yPoints = {y, y, y - (int) (dreieck.getHoehe() * 10)};
            g.drawPolygon(xPoints, yPoints, 3);
        }
        for (Rechteck rechteck : figur.getRechtecke()) {
            int x = graphWidth / 2 - (int) (rechteck.getFlaeche() * 10);
            int y = graphHeight / 2;
            int[] xPoints = {x, x + (int) (rechteck.getLaenge() * 10), x + (int) (rechteck.getLaenge() * 10), x};
            int[] yPoints = {y, y, y + (int) (rechteck.getBreite() * 10), y + (int) (rechteck.getBreite() * 10)};
            g.drawPolygon(xPoints, yPoints, 4);
        }
    }
}

public class MyMathGraph {
    public static void main(String[] args) {
        Figur figur = new Figur();

        figur.hinzufuegenDreieck(1, 4.0, 3.0);
        figur.hinzufuegenRechteck(1, 5.0, 2.0);

        figur.hinzufuegenDreieck(2, 6.0, 2.5);
        figur.hinzufuegenRechteck(2, 3.0, 4.0);

        ErgebnisFrame ergebnisFrame = new ErgebnisFrame(figur);
        
        

        GraphFrame graphFrame = new GraphFrame(figur);
        
    }
}
