class FizzBuzz {
    private int n;
    private Semaphore fizzBuzzSemaphore ; 
    private Semaphore fizzSemaphore ; 
    private Semaphore buzzSemaphore ; 
    private Semaphore numberSemaphore ; 

    public FizzBuzz(int n) {
        this.n = n;
        this.fizzBuzzSemaphore = new Semaphore(0);
        this.fizzSemaphore = new Semaphore(0);
        this.buzzSemaphore = new Semaphore(0);
        this.numberSemaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++){
            if(i % 3 == 0 && i % 5 != 0){
                fizzSemaphore.acquire();
                printFizz.run();
                numberSemaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++){
            if(i%5 == 0 && i % 3 != 0){
                buzzSemaphore.acquire();
                printBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++){
            if(i%5 == 0 && i%3 == 0){
                fizzBuzzSemaphore.acquire();
                printFizzBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++){
            numberSemaphore.acquire();
            if(i%3 == 0 && i%5 == 0){
                fizzBuzzSemaphore.release();
            }else if(i%3 == 0){
                fizzSemaphore.release();
            }else if(i%5 == 0){
                buzzSemaphore.release();
            }else{
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }
}