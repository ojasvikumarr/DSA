import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp123{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int maxi = 0 ;
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                maxi = Math.max(maxi , arr[i]);
            }

            int i = 0 ; 
            int j = n-1 ; 
            int k = n-1 ;
            long count = 0 ; 
            // while(k >= 2){
            //     i = 0 ; 
            //     j = k-1 ;
            //     while(i < j){
            //         if(arr[k] != maxi && arr[i] + arr[j] + arr[k] <= maxi){
            //             count += (j - i);
            //             i++ ; 
            //         }else if(arr[k] == maxi && arr[i] + arr[j] <= maxi){
            //             count += (j - i);
            //             i++ ; 
            //         }
            //         j-- ; 
            //     }
            //     k-- ; 
            // }

            while(k >= 2){
                i = 0 ; 
                j = k-1 ; 
                while(i < j){
                    if(arr[i] + arr[j] > arr[k] && arr[i] + arr[j] + arr[k] > maxi){
                        count+= (j-i);
                        j-- ; 
                    }else{
                        i++ ; 
                    }
                }
                k-- ; 
            }

            // long total = (long)n*(n-1)*(n-2)/6 ;
            // long ans = (long)total - count ; 
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}