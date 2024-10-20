import java.util.concurrent.Semaphore;

public class ReaderWriterProblem {
    private int readers = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore wrt = new Semaphore(1);

    public void read() throws InterruptedException {
        mutex.acquire();
        readers++;
        if (readers == 1) {
            wrt.acquire();
        }
        mutex.release();

        // Reading is performed
        System.out.println("Reading...");

        mutex.acquire();
        readers--;
        if (readers == 0) {
            wrt.release();
        }
        mutex.release();
    }

    public void write() throws InterruptedException {
        wrt.acquire();

        // Writing is performed
        System.out.println("Writing...");

        wrt.release();
    }

    public static void main(String[] args) {
        ReaderWriterProblem rwp = new ReaderWriterProblem();

        // Creating reader threads
        Thread[] readerThreads = new Thread[5];
        for (int i = 0; i < readerThreads.length; i++) {
            readerThreads[i] = new Thread(() -> {
                try {
                    rwp.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            readerThreads[i].start();
        }

        // Creating writer threads
        Thread[] writerThreads = new Thread[3];
        for (int i = 0; i < writerThreads.length; i++) {
            writerThreads[i] = new Thread(() -> {
                try {
                    rwp.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            writerThreads[i].start();
        }

        // Waiting for all threads to finish
        try {
            for (Thread thread : readerThreads) {
                thread.join();
            }
            for (Thread thread : writerThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
