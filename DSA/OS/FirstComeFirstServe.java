import java.util.Scanner;

public class FirstComeFirstServe {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        
        int[] arrivalTime = new int[numProcesses];
        int[] burstTime = new int[numProcesses];
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];
        
        // Input arrival time and burst time for each process
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            arrivalTime[i] = scanner.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }
        
        // Calculate waiting time for each process
        waitingTime[0] = 0;
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }
        
        // Calculate turnaround time for each process
        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }
        
        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime /= numProcesses;
        avgTurnaroundTime /= numProcesses;
        
        // Display results
        System.out.println("\nProcess\t Arrival Time\t Burst Time\t Waiting Time\t Turnaround Time");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i + 1) + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        
        scanner.close();
    }
}
