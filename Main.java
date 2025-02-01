import java.util.* ; 

public class Main {
    @SuppressWarnings("unused")
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] Bs = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = i ; 
            Bs[i] = 1 ;
        }
        int q = sc.nextInt();
        int ans = 0 ; 
        while(q-- > 0){
            int type = sc.nextInt();
            if(type == 1){
                int pigeon = sc.nextInt() -1 ;
                int bucket = sc.nextInt() -1 ;
                //first we check its bucket 
                Bs[arr[pigeon]]-- ;
                if(Bs[arr[pigeon]] == 1){
                    ans-- ;
                }
                arr[pigeon] = bucket ;
                Bs[bucket]++ ;
                if(Bs[bucket] == 2){
                    ans++ ;
                }
            }else if(type == 2){
                //print the number of buckets having freq greater than 1 ;
                //iterate pigeon and calculate freq 
                System.out.println(ans);
            }
        }
        sc.close();
    }

   
}