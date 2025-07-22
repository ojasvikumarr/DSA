import java.lang.Thread ;
import java.lang.Runnable ;
public class intro{

    //we can only inherit/extend only one class thus this is drawback of extend thread interface
    public class Ojasvi extends Thread{
        @Override 
        public void run(){
            System.out.println("Ojasvi is running");
            Thread.sleep(500);
        }
    }
    // Now with interface implemented we can inherit one class
    public class Kumar implements Runnable{
        @Override 
        public void run(){
            System.out.println("Kumar is running");
        }
    }
    public class OjasviKumar implements Callable<String>{
        // * Returns Value 
        // * Throws Exceptions 
        // * Future Objects
        //     -It works with future objects to retrieve results   
        @Override 
        public String call(){
            System.out.println("Ojasvi Kumar is runnning");
            return "Ojasvi Kumar";
        }
    }
    public static void main(String[] args){

        // Thread and Runnable only throws unchecked exceptions and no return value 


        // tightly coupled with the THread Logic 
        // We cant use in thread pool , as task is bound to thread 

        //Direct Object is created
        Ojasvi o = new Ojasvi();
        o.start();

        // Separation between teh thread interface and task
        // Runnable can be used in thread pools because task is bound to the thread

        //Runnable Object is passed to thread Object 
        Kumar k = new Kumar();
        Thread thread1 = new Thread(k);
        // it starts thread excution and calls the run method 
        thread1.start();
        // run method wont create a new thread 
        // thread1.start(); if i again call it , then illegal thread start exceptipn a thread that has completed execution cannot be restarted 

        // Thread Pool is a pool creation , where there are a set of already instantiated thread 
        // waiting to be assigned task , THis way limited number of threads are generated and reused 
        // Instead of creating and destroying the threads for every task

        ExecutorService exe = new Executor.newFixedThreadPool(2);
        //Return type is generic 
        Callable<String> task = new OjasviKumar("OJ");

        //Callable Object uses excutorService to execute 
        Future<String> fut1 = exe.submit(task);
    }


    // THREAD SAFETY   
    * refers to code that runs multiple thread safely without any issue 
    * it is achieved by 
    *   1. Synchronization 
    *   2. Imutable oBjects 
    *   3. Concurrent Colection
    *   4. atomic variable 
    *   5. thread loval variable 
    * 
    *  If an exception occurs while excution of the thread then , the thread is terminated 
    * The excetion does not propogate o the parent node and doesnot affect other threads 
    * 
    * Difference between Sleep and wait 
    * sleep causes the thread to pause for a time without releasing the locks and the theread keeps on holding the resources 
    * wait causes he thread to be timedout that leave all the held resources and wait until notified or notifyAll
    * 
    * When the notify method is called , then the idle thread doesnot starts executing immediately rather 
    * * the wait thread is moved to blocked state (Runnable state)
    * * the notified thread wont start exceuting until it has acquired all the locks successfully

}