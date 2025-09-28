package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tasks.Task;
import visual.Visual;

public class TaskModel implements ActionListener {
    private Visual frame;
    private Task[] tasks = {};
    private Task currentTask;
    private Timer timer = new Timer(1000, this);

    public TaskModel() {
        
    }

    public void addVisual(Visual v) {
        frame = v;
    }

    public void addTask(Task t) {
        Task[] temp = tasks;
        tasks = new Task[tasks.length+1];
        System.arraycopy(temp, 0, tasks, 0, temp.length);
        tasks[temp.length] = t;

        if (tasks.length == 1) {
            currentTask = tasks[0];
            timer.setInitialDelay(1000);
            timer.start();
        }

        frame.updateTasks(tasks);
    }

    public void actionPerformed(ActionEvent e) {
        currentTask.incrementTime();
        frame.updateTasks(tasks);
    }
}
