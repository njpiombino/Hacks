package main;
import visual.Visual;
public class Main
{    
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        Visual frame = new Visual(model);

        frame.setVisible(true);
        model.addVisual(frame);
    }
}