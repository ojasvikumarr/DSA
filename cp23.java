import java.util.* ; 
import java.util.Arrays; 

public class cp23 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            solve(arr , l-1 , r-1 , n);
        }
        sc.close();
    }
    public static void solve(int[] arr , int l , int r , int n){
        //sort . sort . sort 
        List<Integer> front = new ArrayList<>();
        List<Integer> back = new ArrayList<>();
        for(int i = 0 ; i <= r ; i++){
            front.add(arr[i]);
        }
        for(int i = l ; i < n ; i++){
            back.add(arr[i]);
        }
        Collections.sort(front);
        Collections.sort(back);
        int numEle = r-l+1 ; 
        long sumA = 0 ; 
        long sumB = 0 ; 
        for(int i = 0 ; i < numEle ; i++){
            sumA += front.get(i);
            sumB += back.get(i);
        }
        if(sumA > sumB){
            System.out.println(sumB);
        }else{
            System.out.println(sumA);
        }
        return ; 
    }
}
