package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Day1Day2 {
    class Solution {
    class Pair{
        String next ;
        double rate ; 
        public Pair(String s, double d){
            this.next = s ; 
            this.rate = d ; 
        }
    }
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String , List<Pair>> graph1 = new HashMap<>();
        Map<String , List<Pair>> graph2 = new HashMap<>();
        Map<String , Boolean> visited = new HashMap<>();
        
        for(int i = 0 ; i < pairs1.size() ; i++){
            List<String> pair = pairs1.get(i);
            String country1 = pair.get(0);
            String country2 = pair.get(1);
            double rate = rates1[i];
            visited.put(country1 , false);
            visited.put(country2 , false);
            //Bidirectional edge 
            graph1.putIfAbsent(country1 , new ArrayList<>());
            graph1.putIfAbsent(country2 , new ArrayList<>());
            graph1.get(country1).add(new Pair(country2 , rate));
            graph1.get(country2).add(new Pair(country1 , (double)1/rate));
        }
        for(int i = 0 ; i < pairs2.size() ; i++){
            List<String> pair = pairs2.get(i);
            String country1 = pair.get(0);
            String country2 = pair.get(1);
            double rate = rates2[i];
            visited.put(country1 , false);
            visited.put(country2 , false);
            //Bidirectional edge 
            graph2.putIfAbsent(country1 , new ArrayList<>());
            graph2.putIfAbsent(country2 , new ArrayList<>());
            graph2.get(country1).add(new Pair(country2 , rate));
            graph2.get(country2).add(new Pair(country1 , (double)1/rate));
        }

        //Now we need to find the largest cycle in this graph 
        //Not basically the largest cycle but the 
        //Cycle with tthe largest rate multiplication 
        //Thinking of DFS on it 
        //From the given source initialCurrency 
        // BFS/DFS to calculate maximum values
        Map<String, Double> day1Amounts = getMaxAmountsI(initialCurrency, graph1);
        Map<String, Double> day2Amounts = getMaxAmountsII(initialCurrency, graph2, day1Amounts);
        return day2Amounts.getOrDefault(initialCurrency , 0.0);
    }

    public Map<String , Double> getMaxAmountsI(String start ,Map<String , List<Pair>> graph ){
        Map<String , Double> maxAmounts = new HashMap<>();
        maxAmounts.put(start , 1.0);

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            String current = q.poll();
            double currAmt = maxAmounts.get(current);
            // if(graph.containKey(current))
            for(Pair p : graph.get(current)){
                String neighbor = p.next ; 
                double rate = p.rate ; 
                double newRate = rate*currAmt ; 

                if(newRate > maxAmounts.getOrDefault(neighbor , 0.0)){
                    maxAmounts.put(neighbor , newRate);
                    q.offer(neighbor);
                }
            }
        }
        return maxAmounts ; 
    }
    public Map<String , Double> getMaxAmountsII(String start , Map<String , List<Pair>> graph , Map<String , Double> initialAmt){
        Map<String , Double> maxAmounts = new HashMap<>(initialAmt);
        // maxAmmounts.put(start , 1.0);

        Queue<String> q = new LinkedList<>(initialAmt.keySet());
        // q.offer(start);

        while(!q.isEmpty()){
            String current = q.poll();
            double currAmt = maxAmounts.get(current);
            if(graph.containsKey(current))
            for(Pair p : graph.get(current)){
                String neighbor = p.next ; 
                double rate = p.rate ; 
                double newRate = rate*currAmt ; 

                if(newRate > maxAmounts.getOrDefault(neighbor , 0.0)){
                    maxAmounts.put(neighbor , newRate);
                    q.offer(neighbor);
                }
            }
        }
        return maxAmounts ; 
    }















    public double dfs(Map<String , List<Pair>> graph , String src , String dest, Map<String ,Boolean> visited ){
        if(src == dest && visited.get(src) == true){
            return 1.0 ; 
        }
        visited.put(src , true);
        double maxi = 1.0 ; 
        //neighbors
        for(Pair p : graph.get(src)){
            String neighbor = p.next ;
            double rate = p.rate; 
            if(visited.get(neighbor) == false){
                visited.put(neighbor , true);
                maxi = Math.max(maxi , rate*dfs(graph , neighbor , dest , visited));
            }
        }
        return maxi ; 
    }
}
}
