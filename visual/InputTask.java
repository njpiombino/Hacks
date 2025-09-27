package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputTask extends JPanel{

    private JLabel label;

    private JButton button;

    private JTextField inputField;

    public InputTask() 
    {
        this.setLayout(new FlowLayout());
        this.label = new JLabel("Write a Task");
        this.button = new JButton("Enter");
        this.inputField = new JTextField(10);
        this.add(label);
        this.add(button);
        this.add(inputField);
    }
}
