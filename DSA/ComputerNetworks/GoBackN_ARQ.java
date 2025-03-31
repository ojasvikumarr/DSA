package ComputerNetworks;
import java.util.* ; 
public class GoBackN_ARQ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of Fraes to be transmitted");
            int frames = sc.nextInt();
            System.out.println("Size of the window ? ");
            int windowSize = sc.nextInt();
            goBackN_ARQ(frames, windowSize);

        sc.close();
    }
    public static void goBackN_ARQ(int frames , int windowSize){
        int i = 1 ; 
        while( i <= frames ){
            System.out.println("Sending " + i + " Frame...");
            if(Math.random() % 4 == 0){
                System.out.println("Frame " + i + " got LOST!!");
                System.out.println("Sending all frames in the window again....");
                i = (int)Math.floor((double)i/windowSize)*windowSize ; 
                continue ; 
            }
            System.out.println("Recieved " + i + " frame");
            System.out.println("Ack sent for frame " + i);
        }
    }
}
