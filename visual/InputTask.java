package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.TaskModel;
import tasks.Task;

public class InputTask extends JPanel{

    private final JLabel label;

    private final JTextField inputField;

    private final JPanel fieldPanel;
    private final JTextField sText;
    private final JTextField mText;
    private final JTextField hText;

    TaskModel model;


    public InputTask(TaskModel m) 
    {
        model = m;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.label = new JLabel("Write a Task");
        this.inputField = new JTextField(30);
        EnterKey();
        this.add(label);
        

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(2,4,15,10));
        this.add(fieldPanel);

        fieldPanel.add(new JLabel("Task Name"));
        fieldPanel.add(new JLabel("Hours"));
        fieldPanel.add(new JLabel("Minutes"));
        fieldPanel.add(new JLabel("Second"));

        fieldPanel.add(inputField);
        hText = new JTextField();
        mText = new JTextField();
        sText = new JTextField();
        hText.setMaximumSize(new Dimension(3,2));
        fieldPanel.add(hText);
        fieldPanel.add(mText);
        fieldPanel.add(sText);
    }

    private void EnterKey()
    {
        inputField.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                String h = hText.getText();
                String m = mText.getText();
                String s = sText.getText();

                int[] times = {Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s)};
                model.addTask(new Task(name,times));
            }
        });
    }
    
}
