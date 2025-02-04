import java.util.*; 

public class cp22 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) arr.add(sc.nextInt());
            solve(arr , n , k);
        }
        sc.close();
    }    
    public class Pair{
        int a ; 
        int b ; 
        public Pair(int a ,int b){
            this.a = a ; 
            this.b = b ; 
        }
    }
    public static void solve(List<Integer> arr , int n , int k){
        //We need to form pairs 
        Collections.sort(arr);
        //Ascending order sorted ; 
        // now we need two pointers ; 
        int a = 0 ; 
        int b = n-1 ; 
        int pairs = 0 ; 
        while(a < b){
            int front = arr.get(a);
            int back = arr.get(b);
            if(front+back == k){
                a++ ; 
                b-- ; 
                pairs++ ; 
            }else if(front+back > k){
                //We need to reduce the sum 
                b-- ; 
            }else{
                //inc the sum 
                a++ ; 
            }
        }
        //Now we check how many non pairs are left 
        int left = n - pairs*2 ; 
        // if left is odd we will lose one more pair
        if(left % 2 != 0){
            System.out.println(pairs-1);
        }else{
            System.out.println(pairs);
        }
        return ; 
    }
}
