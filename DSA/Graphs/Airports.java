package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.LinkedList ;

public class Airports {
    class Solution {
    public List<String> findItineraryX(List<List<String>> tickets) {
        List<String> edges = new ArrayList<>();
        for(List<String> ticket : tickets){
            edges.add(ticket.get(0));
            edges.add(ticket.get(1));
        }
        Collections.sort(edges , (x , y) -> x.compareTo(y));
        HashMap<Integer, String> intTostr = new HashMap<>();
        int counter = 0 ; 
        for(int i = 0 ; i < edges.size() ; i++){
            if(i != edges.size()-1 && edges.get(i).equals(edges.get(i+1))) continue ;
            intTostr.put(counter++ , edges.get(i));
        }
        HashMap<String , Integer> strToint = new HashMap<>();
        counter = 0 ; 
        for(String str : edges){
            if(!strToint.containsKey(str)){
                strToint.put(str , counter++);
            }
        }
        //Now we have a map with integers mapped to the nodes in lexicographical order 
        //Now we need o mke the adjlist 
        ArrayList<PriorityQueue<Integer>> adjList = new ArrayList<>();
        //we have vertices that are equal to the number of counter
        for(int i = 0 ; i < counter ; i++){
            adjList.add(new PriorityQueue<>());
        }
        for(List<String> ticket : tickets){
            int src = strToint.get(ticket.get(0));
            int dest = strToint.get(ticket.get(1));
            adjList.get(src).add(dest);
        }
        //Now we have the adjList created 
        //Now we need to create the function that creates the path 
        List<Integer> ansInt = new ArrayList<>();
        helper(adjList , strToint.get("JFK") , ansInt);
        List<String> ansStr  = new ArrayList<>();
        for(Integer ticket : ansInt){
            ansStr.add(intTostr.get(ticket));
        }
        return ansStr ; 
    }
    public static void helper(ArrayList<PriorityQueue<Integer>> adjList , int src , List<Integer> ans){
        ans.add(src);
        if(adjList.get(src).poll() == null) return ;
        helper(adjList , adjList.get(src).poll() , ans);
        return ;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build the adjacency list with PriorityQueue for lexicographical order
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        // Step 2: Use a stack for DFS to construct the path
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", adjList, result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adjList, LinkedList<String> result) {
        PriorityQueue<String> destinations = adjList.get(airport);

        // Visit all destinations in lexicographical order
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, adjList, result);
        }

        // Add the airport to the result during backtracking
        result.addFirst(airport);
    }
}
}
