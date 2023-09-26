package DesignPattern.MVC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteMVCWithGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NoteModel model = new NoteModel();
            NoteView view = new NoteView();
            NoteController controller = new NoteController(model, view);

            // Erstellen und anzeigen der GUI
            NoteGUI gui = new NoteGUI(controller);
            gui.createAndShowGUI();
        });
    }
}

class NoteModel {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class NoteView {
    public void displayNote(String noteText) {
        System.out.println("Notizinhalt: " + noteText);
    }
}

class NoteController {
    private NoteModel model;
    private NoteView view;

    public NoteController(NoteModel model, NoteView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayNote(model.getText());
    }

    public void updateModel(String newText) {
        model.setText(newText);
    }
}

class NoteGUI {
    private NoteController controller;
    private JFrame frame;
    private JTextField textField;

    public NoteGUI(NoteController controller) {
        this.controller = controller;
    }

    public void createAndShowGUI() {
        frame = new JFrame("Notizen-App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        JButton saveButton = new JButton("Speichern");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newText = textField.getText();
                controller.updateModel(newText);
                controller.updateView();
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(saveButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
