import java.util.*;

public class cp75 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int[] arr = new int[n];
            int cnt = 1 ; 
            for(int i = s.length()-1 ; i>= 0 ; i--){
                char c = s.charAt(i);
                if(c == '<'){
                    arr[i+1] = cnt ; 
                    cnt++ ;
                }
            }
            // for(int ele : arr){
            //     System.out.print(ele +  " ");
            // }
            // System.out.println();
            if(s.charAt(0) == '>'){
                // System.out.println(cnt);
                arr[0] = cnt ;
            }else{
                arr[0] = cnt ;
                arr[1] = cnt-1 ;
            }
            cnt++ ; 
            int idx = 0 ; 
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                if(c == '>'){
                    while(arr[idx] != 0) idx++ ;
                    arr[idx] = cnt ; 
                    cnt++ ;
                }
            }
            for(int ele : arr){
                System.out.print(ele +  " ");
            }
            System.out.println();
        }
        sc.close();
    }
}