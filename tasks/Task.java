package tasks;

public class Task {
    private String taskName;
    private int[] goalTimes;
    private int[] currentTimes = {0,0,0}; 

    public Task(String n, int[] g) {
        taskName = n;
        goalTimes = g;
    }

    public String getName() {
        return taskName;
    }

    public int[] getGoalTimes() {
        return goalTimes;
    }

    public int[] getCurrentTimes() {
        return currentTimes;
    }

    public void setCurrentTimes(int[] c) {
        currentTimes = c;
    }
}