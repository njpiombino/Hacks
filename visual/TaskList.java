package visual;

import java.awt.*;
import javax.crypto.NullCipher;
import javax.swing.*;
import tasks.Task;

public class TaskList extends JPanel{
    private Task[] tasks = {};
    JPanel upperPanel;
    JPanel lowerPanel;
    Task currentTask;

    public TaskList() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        makeUpperPanel();
        makeLowerPanel();
    }
    
    public TaskList(Task[] t) {
        makeUpperPanel();
        makeLowerPanel();
        tasks = t;
    }

    public void updateTasks(Task[] t) {
        tasks = t;
        displayTasks();
    }

    public void makeUpperPanel() {
        upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        this.add(upperPanel);

        JLabel titleLabel = new JLabel("What tasks do you have?", JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        upperPanel.add(titleLabel);

        JLabel subtitlesLabel = new JLabel("                                           Current Times      Goal Times");
        upperPanel.add(subtitlesLabel);
    }

    public void makeLowerPanel() {
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
        lowerPanel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayTasks();
        JScrollPane scrollPane = new JScrollPane(lowerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        this.add(scrollPane);
    }

    public void displayTasks() {
        lowerPanel.removeAll();
        for (int i = 0; i<tasks.length; i++) {
            int[] ct = tasks[i].getCurrentTimes();
            int[] gt = tasks[i].getGoalTimes();
            String s = "Task " + (i+1) + ". "; 
            String nextTask = tasks[i].getName();
            if(nextTask.length() > 17)
            {
                nextTask = nextTask.substring(0,16);
            }
            
            s += String.format("%-17s%02d:%02d:%02d      %02d:%02d:%02d                                                                    ",
                   nextTask, ct[0], ct[1], ct[2],
                   gt[0], gt[1], gt[2]);
            JLabel l = new JLabel(s);
            l.setFont(new Font("Monospaced", Font.BOLD, 12));
            if(currentTask == tasks[i] || currentTask == null)
            {
                l.setOpaque(true);
                l.setBackground(Color.GRAY);
            }
            // if(currentTask.getCurrentTimes() >= currentTask.getGoalTimes())
            // {

            // }
            lowerPanel.add(l);
        }
        lowerPanel.repaint();
        this.repaint();
        this.revalidate();
        lowerPanel.revalidate();
    }

    public void setCurrent(Task t) {
        currentTask = t;
        displayTasks();
    }
}
