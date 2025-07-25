* Why newCachedThreadPool is better than newFixedThreadPool , when there are a lot of IO operatiosn?
it is so because , IO operations takes a lot of time waiting , 
in newfixedThreadPool we have a fixed amount of threads , so when these threads are occupied 
with IO operations , then we have a few threads availble to handle the remaining task 

As newCachedThreadPool , is dynamic in nature , and it can increase the threads dynamically , 
based to our needs , thus when IO operations are done then threads are increased to compensate the waiting 

Thereby , untilization of CPU during the waiting period

There is advantage in newCachedThreadPool over newFixedThreadPool , 
that is having automatic thread management in newCachedThreadPool 
as it automatically creates and terminates thread after a certain period of inactivity
whereas 
int newFixedThreadPool , the thread remains there for lifetime 

CPU bound task are there , then you should be using newFixedThreadPool as it wont overload the CPU with threads 
and only the fixed amount of threads will be generated even when there are many task , keeping 
concurrency to minimal 
if we use newCachedTrheadPool here , then the problem will be , for every new task , a new thread will be created 
overflowing the cpu with threads and concurrency 

IO tasks then use newCachedThreadPool , as discussed earlier

Mixed workload , then use ThreadPoolExecutor , which is hybrid , we can set the queue size 
large queue : slow execution 
small queue : task rejection , as the queue will be full 

How thread pools help prevent thread starvation : 
thread starvation happens , when the thread is deprived of resources and is unable to perform the task 
resources can CPU allocation time , Memory , disk etc 
this is prevented by thread pool usage : 
- it manages the queueing of threads 
- it Implements fair scheduling policies

THREAD EXECUTORS 
are high level concurrency frameworks that provides a powerful abstraction over the thread management 

THis simplifies the task of creating , scheduling and maanging the threads and let developers focus on the business logic
rather than thread lfie cycle management 
ExecutoreService executor = Executors.newFixedThreadPool(2);
executor.submit(()=>{
    System.out.println("Hello");
})

ExxecutorServiec exe = Executor.newFixedThreadPool(5);
for(int i = 0 ;i < 9 ; i++){
    exe.execute(() ->{
        System.out.println("Hello");
    })
}

ScheduledExecutorService sch = new Executor.newScheduledThreadPool(5);
sch.schedule(() ->{
    System.out.println("Hello");
} , 3 , TimeUnit.SECONDS);

We can delay task execution or schedule it periodically useful dor cron like jobs , or time sensitive tasks

Executor is the basic interface for defining task execution 
ExecutorService is the class which inherits the Excutor and implements thread life cycle management

execute method of executor service dosenot returns any return value 
it is like fire and orget , and it only accepts runnable tasks as no return value is there
submit method returns future objects and allowa you to retrieve the result and check for exception
it accepts both runnable and callable tasks as it can return future objects and exceptions

Ojasvi kumar hello essss


How does the THreadPoolExecutor decides whether to create a new thread or queue the task ?
* if fewer than core threads are running , then create a new thread 
* if limit has reached then queue the task 
* if queue is full , and the threads are less than the maximum thread count then create a new thread 
* if max reached and queue is full then the task is dropped 

public synchornized void solve(){

}