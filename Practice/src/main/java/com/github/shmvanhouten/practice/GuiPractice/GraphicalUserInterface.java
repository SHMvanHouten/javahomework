package com.github.shmvanhouten.practice.GuiPractice;

import javax.swing.*;
import java.awt.*;


public class GraphicalUserInterface extends JFrame {
    public static void main(String[] args) {
        new GraphicalUserInterface();
    }

    public GraphicalUserInterface() throws HeadlessException {
        this.setSize(400, 400);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("TestFrame");

        JPanel panel =  new JPanel();
        JLabel label = new JLabel("Give me some input");
        label.setToolTipText("does nothing");
        panel.add(label);

        JButton button = new JButton("clickme");
        button.setToolTipText("it's a button");
        panel.add(button);

        JTextField textField = new JTextField("Type Your Input Here", 20);
        panel.add(textField);

        this.add(panel);

        this.setVisible(true);
        textField.requestFocusInWindow();
    }
}
