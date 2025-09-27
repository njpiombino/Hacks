package visual;

import javax.swing.*;

public class Visual extends JFrame
{
    JPanel taskList;
    JPanel inputTask;

    public Visual()
    {        
        this.setTitle("Task Master");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        taskList = new TaskList();
        inputTask = new InputTask();
        this.add(taskList);
        this.add(inputTask);
    }
}





