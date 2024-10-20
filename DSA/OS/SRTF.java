import java.util.*;

class Process {
    int pid;
    int arrivalTime;
    int burstTime;
    int remainingTime;

    Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class SRTF {
    public static void main(String[] args) {
        // Example processes
        Process[] processes = {
            new Process(1, 0, 5),
            new Process(2, 1, 3),
            new Process(3, 2, 8),
            new Process(4, 3, 6)
        };

        SRTF(processes);
    }

    public static void SRTF(Process[] processes) {
        int n = processes.length;
        int currentTime = 0;
        int completed = 0;

        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.remainingTime));
        ArrayList<Integer> ganttChart = new ArrayList<>();
        HashMap<Integer, Integer> completionTime = new HashMap<>();

        while (completed < n) {
            for (Process process : processes) {
                if (process.arrivalTime <= currentTime && process.remainingTime > 0) {
                    pq.add(process);
                }
            }

            if (!pq.isEmpty()) {
                Process currentProcess = pq.poll();
                ganttChart.add(currentProcess.pid);
                currentTime += 1;
                currentProcess.remainingTime -= 1;

                if (currentProcess.remainingTime == 0) {
                    completed++;
                    completionTime.put(currentProcess.pid, currentTime);
                }
            } else {
                ganttChart.add(0); // Idle time
                currentTime++;
            }
        }

        // Display Gantt chart
        System.out.println("Gantt Chart:");
        for (Integer pid : ganttChart) {
            System.out.print(pid + " ");
        }
        System.out.println();

        // Display completion time for each process
        System.out.println("Completion Time:");
        for (Map.Entry<Integer, Integer> entry : completionTime.entrySet()) {
            System.out.println("Process " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
