import java.util.Arrays ; 
import java.util.* ; 
public class cp51 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ;i++) arr[i] = sc.nextInt();
            System.out.println(solve(arr , n , k));
        }
        sc.close();
    }
    // static Map<Integer , List<Integer>> map ; 
    // static TreeSet<Integer> set ;
    static class Pair{
        int val ; 
        int idx ; 
        public Pair(int v , int i){
            this.val = v ; 
            this.idx = i ; 
        }
    }
    public static long solve(int[] arr , int n , int k){    
        List<Pair> ls = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            ls.add(new Pair(arr[i] , i));
        }
        //descending sort on basis of val 
        Collections.sort(ls , (a ,b) -> b.val - a.val);
        // set = new TreeSet<>();
        long sum = 0 ;
        if(k == 1){
            long maxi = Integer.MIN_VALUE ;
            for(int i = 0 ; i < n ; i++){
                long sumA = 0 ;
                sumA = ls.get(i).val ; 
                if(ls.get(i).idx == 0){
                    sumA = sumA + arr[n-1];
                }else if(ls.get(i).idx == n-1){
                    sumA = sumA + arr[0];
                }else{
                    sumA = sumA + Math.max(arr[0] , arr[n-1]);
                }
                maxi = Math.max(maxi , sumA);
            }
            return maxi ; 
            // long sumA = 0 ;
            // sumA = ls.get(0).val ; 
            // if(ls.get(0).idx == 0){
            //     sumA = sumA + arr[n-1];
            // }else if(ls.get(0).idx == n-1){
            //     sumA = sumA + arr[0];
            // }else{
            //     sumA = sumA + Math.max(arr[0] , arr[n-1]);
            // }

            // long sumB = 0 ;
            // sumB = ls.get(1).val ; 
            // if(ls.get(1).idx == 0){
            //     sumB =  sumB + arr[n-1];
            // }else if(ls.get(1).idx == n-1){
            //     sumB = sumB + arr[0];
            // }
            // sumB = sumB + Math.max(arr[0] , arr[n-1]);
            // return Math.max(sumA , sumB);
        }
        //index of the blue element at the start
        int first = Integer.MAX_VALUE ; 
        //index of the blue element at the end
        int lastidx = Integer.MIN_VALUE ;
        int last = 0; 
        for(int j = 0; j < k ; j++) {
            sum = sum + ls.get(j).val;
            // set.add(ls.get(j).idx);
            first = Math.min(first , ls.get(j).idx);
            lastidx = Math.max(lastidx , ls.get(j).idx);
            last = ls.get(j).val ;
        }
        //If duplicate is there of k+1 element in the k elements then we just return sum 
        // System.out.println(ls.get(k).val);
        if(ls.get(k).val == last){
            sum = sum + ls.get(k).val;
            return sum ; 
        } 
        // System.out.println(sum + " --");
        //Now the main thing is to find the k+ith element to get max cost 
        for(int i = k ; i < n ; i++){
            int kth = ls.get(i).idx ; 
            // System.out.println(kth + " idx");
            // int first = set.first();
            // int lastidx = set.last() ; 
            if(kth < first || kth > lastidx){
                // System.out.println("Hit");
                if(kth == 0 || kth == n-1 || kth == first-1 || kth == lastidx+1){
                    sum = sum + ls.get(i).val;
                    return sum ; 
                }
            }else{
                sum = sum + ls.get(i).val;
                return sum ; 
            }
        }
        System.out.println(sum); 
        return sum ; 
    }
 
}
