package main;

import tasks.Task;
import visual.Visual;

public class TaskModel {
    private Visual frame;
    private Task[] tasks = {};

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

        frame.updateTasks(tasks);
    }
}
