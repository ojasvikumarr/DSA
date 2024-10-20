import java.util.Scanner;

public class BankersAlgorithm {
    private int[][] max;
    private int[][] allocation;
    private int[][] need;
    private int[] available;
    private int numOfProcesses;
    private int numOfResources;

    public BankersAlgorithm(int[][] max, int[][] allocation, int[] available) {
        this.max = max;
        this.allocation = allocation;
        this.available = available;
        this.numOfProcesses = max.length;
        this.numOfResources = max[0].length;
        this.need = new int[numOfProcesses][numOfResources];
        calculateNeed();
    }

    private void calculateNeed() {
        for (int i = 0; i < numOfProcesses; i++) {
            for (int j = 0; j < numOfResources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }

    public boolean isSafeState() {
        boolean[] finish = new boolean[numOfProcesses];
        int[] work = new int[numOfResources];
        System.arraycopy(available, 0, work, 0, numOfResources);

        int count = 0;
        while (count < numOfProcesses) {
            boolean found = false;
            for (int i = 0; i < numOfProcesses; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < numOfResources; j++) {
                        if (need[i][j] > work[j]) {
                            break;
                        }
                    }
                    if (j == numOfResources) {
                        for (int k = 0; k < numOfResources; k++) {
                            work[k] += allocation[i][k];
                        }
                        finish[i] = true;
                        found = true;
                        count++;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numOfProcesses = scanner.nextInt();
        System.out.print("Enter the number of resources: ");
        int numOfResources = scanner.nextInt();

        int[][] max = new int[numOfProcesses][numOfResources];
        int[][] allocation = new int[numOfProcesses][numOfResources];
        int[] available = new int[numOfResources];

        System.out.println("Enter the maximum resources required by each process:");
        for (int i = 0; i < numOfProcesses; i++) {
            System.out.print("For process " + i + ": ");
            for (int j = 0; j < numOfResources; j++) {
                max[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the allocated resources for each process:");
        for (int i = 0; i < numOfProcesses; i++) {
            System.out.print("For process " + i + ": ");
            for (int j = 0; j < numOfResources; j++) {
                allocation[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the available resources:");
        for (int i = 0; i < numOfResources; i++) {
            available[i] = scanner.nextInt();
        }

        BankersAlgorithm banker = new BankersAlgorithm(max, allocation, available);
        if (banker.isSafeState()) {
            System.out.println("The system is in a safe state.");
        } else {
            System.out.println("The system is in an unsafe state.");
        }

        scanner.close();
    }
}
