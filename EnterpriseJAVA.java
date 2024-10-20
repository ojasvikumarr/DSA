import java.lang.Thread; 
// import java.lang.Runnable;

public class EnterpriseJAVA {
    static class threading extends Thread{
        int num ;
        public threading(int n ){
            this.num = n;
        }
        public void run(){
            for(int i = 0 ; i < 1000 ; i++){
                System.out.println("I'm fine !! what about you...");
            }
        }
    }
    static class threading2 extends Thread{
        int num ;
        public threading2(int n ){
            this.num = n;
        }
        public void run(){
            for(int i = 0 ; i < 1000 ; i++){
                System.out.println("Hello , How you doin'n !!");
            }
        }
    }
    // class threader extends threading {
    //     boolean flag ;
    //     public threader(){
    //         flag= false ;
    //     }
    //     public threader(boolean n){
    //         this.flag = n ;
    //     }
    //     public void run(){

    //     }
    // }

    static class bullet implements Runnable{
        public void run(){
            for(int i = 0 ; i < 10 ; i++){
                System.out.println("Bullet fired!!");
            }
        }
    }
    public static void main(String[] argv){
        // threading obj1 = new threading(10);
        // threading2 obj2 = new threading2(10);
        // obj1.start();
        // obj2.start();
        // bullet b = new bullet();

    }
}
