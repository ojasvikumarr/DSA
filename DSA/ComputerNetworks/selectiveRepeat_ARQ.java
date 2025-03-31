package ComputerNetworks;

import java.util.Scanner;

public class selectiveRepeat_ARQ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of Frames to be transmitted");
            int frames = sc.nextInt();
            selectiveRepeaT_ARQ(frames);

        sc.close();
    }
    public static void selectiveRepeaT_ARQ(int frames ){
        int i = 1 ; 
        boolean[] recieved = new boolean[frames+1];
        while( i <= frames ){
            System.out.println("Sending " + i + " Frame...");
            if(Math.random() % 4 == 0){
                continue ; 
            }
            recieved[i] = true ; 
            System.out.println("Recieved " + i + " frame");
            System.out.println("Ack sent for frame " + i);
        }

        for(i = 1 ; i <= frames ; i++){
            if(recieved[i] == false){
                System.out.println("Retransmitting Lost Frame " + i );
                System.out.println("Frame " + i + " recieved ");
            }
        }
    }
}
