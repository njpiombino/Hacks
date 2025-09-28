package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.TaskModel;
import tasks.Task;

public class InputTask extends JPanel{

    private final JLabel label;

    private final JTextField inputField;

    private final JPanel fieldPanel;
    private final JTextField sText;
    private final JTextField mText;
    private final JTextField hText;
    private final JPanel buttons;
    private JButton submit;
    private JButton nextTask;
    private JButton startTime;
    private JButton stopTime;

    TaskModel model;


    public InputTask(TaskModel m) 
    {
        model = m;

        this.setBorder(new EmptyBorder(20,20,20,20));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.label = new JLabel("Write a Task");
        this.inputField = new JTextField(30);
        label.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label);
        

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(2,4,15,10));
        fieldPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(fieldPanel);

        fieldPanel.add(new JLabel("Task Name"));
        fieldPanel.add(new JLabel("Hours"));
        fieldPanel.add(new JLabel("Minutes"));
        fieldPanel.add(new JLabel("Second"));

        fieldPanel.add(inputField);
        hText = new JTextField("00");
        mText = new JTextField("00");
        sText = new JTextField("00");
        hText.setMaximumSize(new Dimension(3,2));
        fieldPanel.add(hText);
        fieldPanel.add(mText);
        fieldPanel.add(sText);

        buttons = Buttons();
        buttons.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(5));
        this.add(buttons);
        Submit();
        NextTask();
        StartTime();
        StopTime();

    }

    private JPanel Buttons()
    {
        JPanel Buttons = new JPanel();
        Buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        this.submit = new JButton("Submit");
        this.nextTask = new JButton("Next Task");
        this.startTime = new JButton("Start Timer");
        this.stopTime = new JButton("Stop Time");
        Buttons.add(submit);
        Buttons.add(nextTask);
        Buttons.add(startTime);
        Buttons.add(stopTime);
        return Buttons;
    }

    private void Submit()
    {
        submit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                String h = hText.getText();
                String m = mText.getText();
                String s = sText.getText();

                try
                {
                    int[] times = {Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s)};
                    model.addTask(new Task(name,times));
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(InputTask.this, "Please Input a Number!!! They look like this \"0\"","Not A Number",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }

    private void NextTask()
    {
        nextTask.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                model.incrementTask();
            }
        });
    }

    private void StartTime()
    {
        startTime.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                model.StartTime();
            }
        });
    }

    private void StopTime()
    {
        stopTime.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                model.StopTime();
            }
        });
    }
    
}
