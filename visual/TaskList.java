package visual;

import java.awt.*;
import javax.swing.*;
import tasks.Task;

public class TaskList extends JPanel{
    private Task[] tasks = {};
    JPanel upperPanel;
    JPanel lowerPanel;

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
        displayTasks();
        JScrollPane scrollPane = new JScrollPane(lowerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        this.add(scrollPane);
    }

    public void displayTasks() {
        lowerPanel.removeAll();
        for (int i = 0; i<tasks.length; i++) {
            int[] ct = tasks[i].getCurrentTimes();
            int[] gt = tasks[i].getGoalTimes();
            String s = "Task " + (i+1) + ". " + tasks[i].getName();
            for (int j = tasks[i].getName().length(); j<30;j++) {
                s += ' ';
            }
            s += ct[0] + ":" + ct[1] + ":" + ct[2] + "                      " + gt[0] + ":" + gt[1] + ":" + gt[2];
            JLabel l = new JLabel(s);
            lowerPanel.add(l);
        }
        lowerPanel.repaint();
        this.repaint();
        this.revalidate();
        lowerPanel.revalidate();
    }
}
