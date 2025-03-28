import java.io.*;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ; 
public class cp59 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i ++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(a, b, n)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static String solve(int[] a , int[] arr , int n){
        // HashSet<Integer> setA = new HashSet<>();
        // HashSet<Integer> setB = new HashSet<>();
        HashMap<Integer , Integer> mapA = new HashMap<>();
        HashMap<Integer , Integer> mapB = new HashMap<>();
        int maxi = 0 ; 
        int start = 0 ; 
        int end = 0 ; 
        int i = 1; 
        while(i < n){
            if(arr[i] >= arr[i-1]){
                //we need to start the set 
                // setA.add(a[i-1]);
                // setB.add(arr[i-1]);
                int l = i-1 ;
                mapA.put(a[i-1] , 1);
                mapB.put(arr[i-1] , 1);
                while(i < n && arr[i] >= arr[i-1]){
                    // setA.add(a[i]);
                    // setB.add(arr[i]);
                    // System.out.println("Check  --");
                    mapA.put(a[i] , mapA.getOrDefault(a[i] , 0)+1);
                    mapB.put(arr[i] , mapB.getOrDefault(arr[i] , 0)+1);
                    i++ ;
                }
                // System.out.println(mapA);
                if(mapA.equals(mapB)){
                    // System.out.println("DOnw");
                    if(maxi < i-l){
                        maxi = i-l ; 
                        start = l ;
                        end = i-1 ; 
                    }
                }else{
                    //we increment the left pointer 
                    while(l < i){
                        mapA.put(a[l] , mapA.get(a[l])-1);
                        mapB.put(arr[l] , mapB.get(arr[l])-1);
                        if(mapA.equals(mapB)){
                            if(maxi < i-l){
                                maxi = i-l ; 
                                start = l ;
                                end = i-1 ; 
                            }
                            break ; 
                        }
                        l++ ; 
                    }
                }
                mapA.clear();
                mapB.clear();
            }else{
                i++ ; 
            }
        }
        return (start+1) + " " + (end+1) ; 
    }
} 
