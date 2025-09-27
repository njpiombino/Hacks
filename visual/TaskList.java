package visual;

import java.awt.*;
import javax.swing.*;

public class TaskList extends JPanel{
    public TaskList() {
        JLabel titleLabel = new JLabel("What tasks do you have?", JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBackground(Color.white);
        this.add(titleLabel);
    }
}
