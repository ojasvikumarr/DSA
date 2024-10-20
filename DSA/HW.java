public class HW {
    public static void Occ( int arr[] , int n , int k){
        if ( n == arr.length ){
            return;
        }
        //int currElement = arr[n];
        if (arr[n] == k){
            System.out.print(n+" ");
        }
        Occ(arr, n+1 , k);
        //return;
    }


    public static void Convert( int n ){
        if( n == 0 ){
            return;
        }
        String Digits[] = { "Zero" , "One" , "Two" , "Three" , "Four" , "FIve" , "SIx" , "Seven" , "EIght" , "Nine"};
        Convert(n/10);
        int lastDIgit = (n % 10);
        System.out.print(Digits[lastDIgit] +" ");
    }

    public static void LengthString (String str , int n){
        
    }
    public static void main (String args[]){
        int arr[] = {3,2,4,5,6,2,7,2,2};
        Occ(arr, 0, 2);
        int a = 1970 ;
        Convert(a);
    }
}
