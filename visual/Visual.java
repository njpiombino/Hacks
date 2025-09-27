package visual;

import javax.swing.JFrame;

public class Visual extends JFrame
{
    private JFrame frame;
    private int timerInput; 
    


    public Visual()
    {
        this.timerInput = 0;
        this.frame = makeWindow();
    }

    private JFrame makeWindow()
    {
        JFrame frame = new JFrame("Task_Master");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
}





