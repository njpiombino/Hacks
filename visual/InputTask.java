package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputTask extends JPanel{

    private final JLabel label;

    private final JTextField inputField;

    private final JLabel result;

    public InputTask() 
    {
        this.setLayout(new FlowLayout());
        this.label = new JLabel("Write a Task");
        this.inputField = new JTextField(30);
        EnterKey();
        this.result = new JLabel(" ");
        this.result.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(label);
        this.add(inputField);
        this.add(result);
        
    }

    private void EnterKey()
    {
        inputField.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                result.setText(text);
            }
        });
    }
    
}
