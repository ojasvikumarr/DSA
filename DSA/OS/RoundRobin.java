import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

class RoundRobin {

    public static void roundRobinScheduling(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0;
        int totalProcesses = processes.size();
        int[] waitingTime = new int[totalProcesses];
        int[] turnaroundTime = new int[totalProcesses];

        while (!processes.isEmpty() || !queue.isEmpty()) {
            while (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                queue.offer(processes.remove(0));
            }

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            Process currentProcess = queue.poll();
            int executionTime = Math.min(quantum, currentProcess.remainingTime);
            currentProcess.remainingTime -= executionTime;
            currentTime += executionTime;

            if (currentProcess.remainingTime > 0) {
                queue.offer(currentProcess);
            } else {
                turnaroundTime[currentProcess.id] = currentTime - currentProcess.arrivalTime;
                waitingTime[currentProcess.id] = turnaroundTime[currentProcess.id] - currentProcess.burstTime;
            }
        }

        // Display results
        System.out.println("Process\t Waiting Time\t Turnaround Time");
        for (int i = 0; i < totalProcesses; i++) {
            System.out.println((i + 1) + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(0, 0, 5));
        processes.add(new Process(1, 1, 3));
        processes.add(new Process(2, 2, 8));
        processes.add(new Process(3, 3, 6));

        int quantum = 2;

        roundRobinScheduling(processes, quantum);
    }
}
