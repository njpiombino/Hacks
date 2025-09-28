package visual;

import java.awt.*;
import javax.swing.*;
import tasks.Task;

public class TaskList extends JPanel{
    private Task[] tasks = {};
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private Task currentTask;
    private int currentIndex;
    private final Color GRAY = new Color(209, 216, 219);
	private final Color GREEN = new Color(0, 180, 92);
    private final Color RED = new Color(185, 27, 27);

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
        lowerPanel.setOpaque(true);
        lowerPanel.setBackground(GRAY);
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
            JLabel l1 = new JLabel(s.substring(0,25));
            JLabel l2 = new JLabel(s.substring(25,39));
            JLabel l3 = new JLabel(s.substring(39));
            l1.setFont(new Font("Monospaced", Font.BOLD, 12));
            l2.setFont(new Font("Monospaced", Font.BOLD, 12));
            l3.setFont(new Font("Monospaced", Font.BOLD, 12));

            l1.setOpaque(true);
            l2.setOpaque(true);
            l3.setOpaque(true);

            if(currentTask == tasks[i] || currentTask == null)
            {
                l1.setBackground(Color.GRAY);
                l2.setBackground(Color.GRAY);
                l3.setBackground(Color.GRAY);
            }
            else
            {
                l1.setBackground(GRAY);
                l2.setBackground(GRAY);
                l3.setBackground(GRAY);
            }

            if(tasks[i].getCurTotal() <= tasks[i].getTotalTime()) {
                l2.setForeground(GREEN);
            }
            else {
                l2.setForeground(RED);
            }

            if(i < currentIndex)
            {
                l1.setBackground(Color.lightGray);
                l2.setBackground(Color.lightGray);
                l3.setBackground(Color.lightGray);
            }

            JPanel labelPanel = new JPanel();
            labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
            labelPanel.setOpaque(true);
            lowerPanel.add(labelPanel);
            labelPanel.add(l1);
            labelPanel.add(l2);
            labelPanel.add(l3);
            labelPanel.repaint();
            labelPanel.revalidate();
        }
        lowerPanel.repaint();
        this.repaint();
        this.revalidate();
        lowerPanel.revalidate();
    }

    public void setCurrent(Task t, int index) {
        currentTask = t;
        currentIndex = index;
        displayTasks();
    }
}
