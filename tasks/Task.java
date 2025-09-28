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

    public void incrementTime() {
        currentTimes[2]++;
        if (currentTimes[2] == 60) {
            currentTimes[1]++;
            currentTimes[2] = 0;

            if (currentTimes[1] == 60) {
                currentTimes[1] = 0;
                currentTimes[0]++;
            }
        }
    }
}