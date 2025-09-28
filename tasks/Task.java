package tasks;

public class Task {
    private String taskName;
    private int[] goalTimes;
    private int[] currentTimes = {0,0,0}; 
    private int totalTime;
    private int curTotal;

    public Task(String n, int[] g) {
        taskName = n;
        goalTimes = g;
        totalTime = g[0] * 3600 + g[1] * 60 + g[2];
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

    public int getTotalTime() {
        return totalTime;
    }

    public int getCurTotal() {
        curTotal = currentTimes[0] * 3600 + currentTimes[1] * 60 + currentTimes[2];
        return curTotal;
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