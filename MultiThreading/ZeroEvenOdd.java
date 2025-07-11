class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore ;
    private Semaphore evenSemaphore ; 
    private Semaphore oddSemaphore ; 
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        this.evenSemaphore = new Semaphore(0);
        this.oddSemaphore = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean isOdd = true ; 
        for(int i = 1 ; i <= n ; i++){
            zeroSemaphore.acquire(); //use the permit
            printNumber.accept(0);
            if(isOdd){
                oddSemaphore.release();// adding permit dynamically
            }else{
                evenSemaphore.release();//adding permit dynamically 
            }
            isOdd = !isOdd ; 
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2 ; i <= n ; i += 2){
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1 ; i <= n ; i += 2){
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}