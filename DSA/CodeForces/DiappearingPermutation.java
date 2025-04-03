package CodeForces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DiappearingPermutation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);        
        int t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            int[] arr = new int[n];
            int[] query = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt()-1;
            for(int i = 0 ; i < n ; i++) query[i] = sc.nextInt()-1;
            init();
            solve(arr, query, n);
        }
        sc.close();
    }
    static int n ; 
    static int parent[] ; 
    static int size[] ; 
     public static void init(){
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            size[i] = 1; 
        }
     }
     public static int find(int x){
        if(parent[x] == x){
            return x ; 
        }
        return parent[x] = find(parent[x]);
     }
     public static void union(int u , int v){
        int parU = find(u);
        int parV = find(v);
        if(parU != parV){
            if(size[parU] > size[parV]){
                parent[parV] = parU ;
                size[parU] += size[parV];
            }else{
                parent[parU] = parV ;
                size[parV] += size[parU];
            }
        }
     }
    public static void solve(int[] arr , int[] query , int n){
        for(int i = 0 ; i < n ; i++){
            union(arr[i] , i);
        }
        StringBuilder sb = new StringBuilder() ; 
        int prev = 0 ; 
        Set<Integer> set = new HashSet<>() ;
        for(int i = 0 ; i < n ; i++){
            int q = query[i];
            int parQ = find(q);
            if(set.contains(parQ)){
                //we dont add anything just append prev ans 
                sb.append(prev).append(" ") ;
            }else{
                sb.append(size[parQ]+prev).append(" ") ;
                set.add(parQ);
                prev = size[parQ] + prev ; 
            }
        }
        System.out.println(sb.toString());
    }
}
