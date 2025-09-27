package main;
<<<<<<< HEAD
import visual.Visual;
import tasks.Task;
public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String x = "link";
        if(x.equals("link"))
        {
        	System.out.println(x);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        Visual frame = new Visual();
        frame.setVisible(true);
=======

import visual.Visual;

public class Main {
    public static void main(String[] args) {
        Visual v = new Visual();
>>>>>>> bb56d98c236269d4068efc6fdfe0809df2507194
    }
}