package DpOnBitMasking;
import java.util.*  ;

public class BasicBitmasking {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] masks = new int[t];
        int itr = 0 ;
        for(int x = 0 ; x < t ; x++){
            //we need to set the mask of each person 
            int days = sc.nextInt();
            int mask = 0 ; 
            for(int i = 0; i < days ; i++){
                int day = sc.nextInt();
                mask = (mask | (1<<day)) ; 
            }
            masks[itr++] = mask ; 
        }
        //Now we have the array of masking of the number of days the worker will work so now we will have to take intersection 
        //Of each worker n2 that is then we will take out the highest days out 
        for(Integer it : masks){
            System.out.println(it);
            System.out.println(Integer.toBinaryString(it));
        }
        System.out.println("Now we check the inersections " + t);
        //Now we find the intersections 
        for(int i = 0 ; i < t ; i++){
            for(int j = i+1 ; j < t ; j++){
                // System.out.println("Hello WOrld!!");
                int intersection = (masks[i] & masks[j]);
                // System.out.println(intersection) ; 
                System.out.println(Integer.bitCount(intersection));
            }
        }
        sc.close();
    }
}
