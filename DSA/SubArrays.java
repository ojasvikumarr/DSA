 public class SubArrays{
    public static void subarray(int number[]){
        int total = 0; 
        for (int i = 0 ; i<number.length ; i++){
            int start = i;
            int sum = 0;
            for ( int j = i ; j<number.length ; j++){//i did <= which stopped the loop 
                int end = j ; 
                for ( int k=start  ; k <= end ; k++){
                    sum += number[k];
                    System.out.print(number[k]+" ");
                    total++ ;
                }
                System.out.println();
                
            }
            System.out.println("sum of the subarrays is :"+sum);
            System.out.println();
            
        }
        System.out.println("Total no. of pairs: "+total);
    }
    public static void main ( String args[] ){
        int number[] = {8,2,6,4,7,3,20};
        subarray(number);
        
    }
 }