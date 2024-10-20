import java.util.concurrent.Semaphore;

public class DekkerAlgorithm {
    private volatile int turn = 0;
    private volatile boolean[] wants = {false, false};
    private Semaphore[] semaphores = {new Semaphore(1), new Semaphore(1)};

    public void enterCriticalSection(int id) {
        int otherId = 1 - id;
        wants[id] = true;
        while (wants[otherId]) {
            if (turn != id) {
                wants[id] = false;
                while (turn != id) {
                    Thread.yield();
                }
                wants[id] = true;
            }
        }
    }

    public void leaveCriticalSection(int id) {
        turn = 1 - id;
        wants[id] = false;
    }

    public static void main(String[] args) {
        DekkerAlgorithm dekker = new DekkerAlgorithm();

        Runnable task1 = () -> {
            int id = 0;
            while (true) {
                dekker.enterCriticalSection(id);
                System.out.println("Critical section entered by Thread 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dekker.leaveCriticalSection(id);
            }
        };

        Runnable task2 = () -> {
            int id = 1;
            while (true) {
                dekker.enterCriticalSection(id);
                System.out.println("Critical section entered by Thread 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dekker.leaveCriticalSection(id);
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
