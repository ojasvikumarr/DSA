public class MaxSubarraySum {
    public static void PrefixSum(int numbers[]){
        int curSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length] ;
        //calculate array
        prefix[0]= numbers[0];
        for ( int i = 1 ; i <prefix.length ; i ++  ){
            prefix[i] =prefix[i-1]+numbers[i]; 
        }


        for( int i = 0 ; i<numbers.length ; i++){
            int start = i ; 
            for( int j=i ; j<numbers.length ; j++){
                int end = j ;
                curSum = start == 0 ? prefix[end] : prefix[end] - prefix [ start - 1 ];
                //for ( int k = start ; k<+end ; k++){
                //    curSum +=number[k];
                //}
            //System.out.println(curSum);
            if( MaxSum <curSum){
                MaxSum = curSum;
            }
            }

        }
System.out.println(MaxSum);

       

    }
    public static void MaxSubarraySuM(int number[]){
        int curSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for( int i = 0 ; i<number.length ; i++){
            int start = i ; 
            for( int j=i ; j<number.length ; j++){
                int end = j ;
                curSum = 0;
                for ( int k = start ; k<+end ; k++){
                    curSum +=number[k];

                }
            System.out.println(curSum);
            if( MaxSum <curSum){
                MaxSum = curSum;
            }
            }

        }
System.out.println(MaxSum);

        } 
    public static void main (String args[]){
    int number []={2,3,2,4,9,10,13};
    PrefixSum(number); 
    }
}
