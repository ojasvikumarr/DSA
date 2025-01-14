package Graphs;

import java.util.ArrayList;
import java.util.List;

public class FrienndUnFriend {
    class Solution {
    int[] parent ; 
    int[] rank ; 
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i ;
    }
    public int find(int x){
        if(parent[x] == x){
            return x ;
        }
        return parent[x] = find(parent[x]);
    }
    public boolean canBeFrnd(List<List<Integer>> unFriend , int u , int v){
        int parU = find(u);
        int parV = find(v);
        if(parU == parV){
            return true ;
        }else{
            if(checkList(unFriend , u , v) == false){
                return false ;
            }
            //Not returned that means we can be friends 
            union(u , v);
        }
        return true ;
    }
    public boolean checkList(List<List<Integer>> unFriend , int u , int v){
        int parU = find(u);
        int parV = find(v);
        for(int i = 0 ; i < parent.length ; i++){
            if(parent[i] == parU){
                for(Integer unFrnd : unFriend.get(i)){
                    if(parent[unFrnd] == parV) return false;
                }
            }
            if(parent[i] == parV){
                for(Integer unFrnd : unFriend.get(i)){
                    if(parent[unFrnd] == parU) return false;
                }
            }
        }
        return true;
    }
    public void union(int u , int v){
        int parU = find(u);
        int parV = find(v);
        if(rank[parU] == rank[parV]){
            parent[parU] = parV ; 
            rank[parV]++ ;
        }else if(rank[parU] > rank[parV]){
            parent[parV] = parU ;
        }else{
            parent[parU] = parV ;
        }
    }
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        List<List<Integer>> unFriend = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) unFriend.add(new ArrayList<>());

        init(n);
        for(int[] res : restrictions){
            int u = res[0];
            int v = res[1];
            unFriend.get(u).add(v);
            unFriend.get(v).add(u);
        }
        boolean[] result = new boolean[requests.length];
        for(int i = 0 ; i < requests.length ; i++){
            int[] req = requests[i];
            int u = req[0];
            int v = req[1];
            result[i] = canBeFrnd(unFriend , u , v) ;
        }
        return result ; 
    }
}
}
