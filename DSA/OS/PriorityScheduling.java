import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int priority;

    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class PriorityScheduling {

    public static void priorityScheduling(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        PriorityQueue<Process> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
        int currentTime = 0;
        int totalProcesses = processes.size();
        int[] waitingTime = new int[totalProcesses];
        int[] turnaroundTime = new int[totalProcesses];

        int completedProcesses = 0;
        while (completedProcesses < totalProcesses) {
            while (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                queue.offer(processes.remove(0));
            }

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            Process currentProcess = queue.poll();
            int executionTime = currentProcess.burstTime;
            currentTime += executionTime;

            turnaroundTime[currentProcess.id] = currentTime - currentProcess.arrivalTime;
            waitingTime[currentProcess.id] = turnaroundTime[currentProcess.id] - currentProcess.burstTime;

            completedProcesses++;
        }

        // Display results
        System.out.println("Process\t Waiting Time\t Turnaround Time");
        for (int i = 0; i < totalProcesses; i++) {
            System.out.println((i + 1) + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(0, 0, 5, 2));
        processes.add(new Process(1, 1, 3, 1));
        processes.add(new Process(2, 2, 8, 3));
        processes.add(new Process(3, 3, 6, 4));

        priorityScheduling(processes);
    }
}
