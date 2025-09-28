package visual;

import java.awt.GridLayout;
import javax.swing.*;
import main.TaskModel;
import tasks.Task;

public class Visual extends JFrame
{
    TaskList taskList;
    InputTask inputTask;
    TaskModel model;

    public Visual(TaskModel t)
    {        
        model = t;

        this.setTitle("Task Master");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        taskList = new TaskList();
        inputTask = new InputTask(model);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1,5,5));
        this.add(panel);
        panel.add(taskList);
        panel.add(inputTask);
    }

    public void updateTasks(Task[] t) {
        taskList.updateTasks(t);
        this.repaint();
        this.revalidate();
    }
}





