package ComputerNetworks;

import java.util.Scanner;

public class StopAndWait_ARQ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

            System.out.println("Enter the number of Frames to be transmitted");
            int frames = sc.nextInt();
            for(int i = 1 ; i <= frames ; i++){
                sender(i);
                boolean recieved = reciever(i);
                if(recieved == false){
                    sender(i);
                }
            }
        sc.close();
    }
    public static void sender(int i ){
        System.out.println("Sender sending frame " + i );
    }
    public static boolean reciever(int i){
        if((int)(Math.random()*4) == 0){
            System.out.println("Frame recieved But ACK Lost");
            return false ; 
        }
        System.out.println("Recieved Frame " + i);
        System.out.println("Reciever Sending ACK...");
        return true ; 
    }
}
