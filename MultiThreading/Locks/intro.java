import java.utils.concurrent.locks ; 

// why use explicit locks instead of semaphore ? 
// - beacuse of greatere access over lock acquire and release 
// - non block structure acquire and release 
// - timed lock or scheduled lock for a specified tiem 
// - allows thread to be interrupted while waiting for locks 
// - release locks from diferent threads 
// - first coms first serve policy 

private final ReentrantLock lock = new ReentrantLock();

public void increment(){
    lock.lock();
    counter++ ; 
    lock.unlock();
}

// Reentrant Lock also called read write lock 

// I) Multipler threads need to read : 
//     they can do simulataneously when no writing 
// II) Exclusive writing : 
//     When a thread is updating data , no other thread is allowed to access the resource

public synchronized void increment(){
    counter++ ; 
}
class Logger{
    Logger instance ;
    private Logger(){
        this.instance = new Logger();
    }

    public static Logger getLogger(){
        synchronized(Logger.class){
            if(instance == null){
                synchronized(Logger.class){
                    return new Logger();
                }
            }
        }
        return instance ;
    }
}
// Synchronized lock are built in the language they automatically acquire and release 
// intrinsic locks , they are simple to use but have blocking behaviour , 
// you cannot acquire syncronized lock with a time out 
// automatic relear of synchronised locks when the block/methods ends 
// even if exception occurs 

// while in reenrant lock you must explicitly call unlcok() to release

// Semaphore is a variable or object used to control access to shared resources 
// by multiple threads , allowing a limited number of threads to access the 
// resource concurrently 

// for example , if semaphore is initialized to 2 , then 2 threads can access the 
// resource simultaneously 

// used for thread synchonization , access control , limiting concurrent access , 
// producer consume pattern , mutual exclusion 

// when there are no permits available then the thread is gone in blocked state 

// semaphore has two operations 
// acquire and release 

// type of semaphore  : 
// binary semaphore 
// has only two states 0 or 1 , used to implement mutex or locks 

import java.util.concurrent.Semaphore ; 
public class intro{
    private static final Semaphore mutex = new Semaphore(1);
    private static final int counter = 0 ;
    public void increment(){
        mutex.acquire();
        counter++ ; 
        mutex.release();
    }
}

Counting semaphore, 
reader writer problem , many readers ( sharing a resource to read )
but only one can write 
it can give multiple permits , 
therefore multiple threads can acquire the semaphore , simultaneously until
all permits are used 
used for : 
- limited access to resources 
- contraolling concurrent database connection 
- Handling thread throttling (limited numebr of threads can only work , no overflow )

private static final Semaphore resourcePool = new Semaphore(3);
resourcePool.acquire();
resourcePool.release();

calling release() w/o a priori acquire() is prefectly legal
it increases the number of permits dynamically at runtime 
allowing more concurrent access than orignally intended 

Barrier synchronisation pattern using semaphore 
barrier ensures that no thread can proceed past a certain
point until all threads have reached the point 

these are specialised thread safe collection implementation 
designed for use in multithreaded environment 

I) Concurrent HashMap :
    if mutliple thread wants to modify the key , then the whole map 
    needs to be locked for one thread , that increases the overhead

    concurrent hashmap , it split the locking or uses of non blocking technique 
    multiple threas can work simultaneously on the resource
    thread safety is ensured 
internal working of hashmap 
array of buckets each bucket can hold a 
- linkedlist 
- if it is increased by a threashold then red black trees are stored int the 
buckets 

Or we can wrap the hashmap that we want to make synchronized that is thread safe 
 
Map<Integer , Integer> map = Collections.synchronizedMap(new HashMap<>());

Map<Integer , Integer> conMap = new ConcurrentHashMap<>();
in this every bucket is synchronized thus only one thread in each bucket 
while in hashMap the whole map needs to be locked for one thread 

Future and completableFuture 
- it is used to represent the result of an asycnhronous computation 
- Future.get() blocks until the result is availble 
- Future does not provide an event driven mechanism to notify when a task completes 