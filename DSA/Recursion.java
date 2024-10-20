

public class Recursion {
    public static void printDec(int n){
        if (n == 1){
            System.out.print(n);
        return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }//here call stack is being used


    //If we dont put an end base value in the recursive function then the function will crash and it will lead to 
    //Stack overflow which means that all the memory in the call stack is filled and eventually it will crash 

    // do it by commenting out the base value of the function
    


    public static void printInc(int n){
        if ( n == 1 ){
            System.out.print(n);
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
        
    }

    public static int Factorial(int n){
        if( n == 0 ){
            return 1;
        }
        // int fnm1 = Factorial(n-1);
        int fn = n*Factorial(n-1);
        return fn;
        
    }

    public static int SumN(int n){
        if (n == 1){
            return 1;
        }
        int sum = n + SumN(n-1);
        return sum;
    }

    //To find out whather the array is sorted or not by th ehelp of recursion 
    public static boolean Sorted ( int arr[] , int i){
        //here the int "i" denotes the index from which we need to see whther the array is sorted
        //Base case
        if( i == arr.length-1){
            return true;
        }
        
        if( arr[i] > arr[i+1]){
            return false;
        }
        return Sorted(arr, i+1);
    }

    //WAF to find the occurence of the first element in the array

    public static int FirstOccurence(int arr[], int i , int k){
        if( i == arr.length - 1){
            return -1;// di d this so that if the key doesnt exists in the the array 
        }
        if ( arr[i] == k){
            return i;
        }
        return FirstOccurence(arr, i + 1 , k);
    }

    //WAF to find the last occurence of the element in the array
    
//    } public static int LastOccurence(int arr[], int i, int k) {
//         if ( i == arr.length ){
//             return -1;
//         }
//         int isFound = LastOccurence(arr, i+1, k);
//         if ( isFound == -1 &&arr[i]== k){
//             return i ;
//         }
//         return isFound;
    


    //Make power funvtion using Recursion

    public static int Power ( int x, int n){
        if (n == 0){
            return 1;
        }
        // int Xnm1 = Power(x, n-1);
        // int Xn = x* Xnm1 ;
        // return Xn;

        //More simpler approach will be 
        return x* Power(x, n-1);
    }


    //More Optimized approach towards Power function with O(Logn) complexity
    public static int OptimizedPower( int x , int n){
        if ( n == 0){
            return 1 ;
        }
        //int Xn =  OptimizedPower(x, n/2)*OptimizedPower(x, n/2);  this statement will give is O(n) as time complexity

        int Halfpower = OptimizedPower(x, n/2);
        int HalfpowerSqr = x * Halfpower;
        if ( n%2 != 0){
            HalfpowerSqr = x*HalfpowerSqr;
        }
        return HalfpowerSqr;
    }

    public static void main(String args[]) {
        printDec(10);
        System.out.println();
        printInc(10);
        System.out.println();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Sorted(arr, 0));
        System.out.println(Factorial(10));
        System.out.println(SumN(10));
        int arr1[] = {1,1,2,1,3,4,2,3,5,67,5,3,2,4,5};
        System.out.println(FirstOccurence(arr1, 0, 5));
       //System.out.println(LastOccurence(arr1, arr1.length, 5));
        System.out.println(Power( 3, 3));
        System.out.println(OptimizedPower(2, 5));
    }


    
}
