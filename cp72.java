import java.util.* ; 
public class cp72 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            for(int i =0 ; i < n ; i++){
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }
            if(set.size() == n){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
            
        }
        sc.close();
    }
}
