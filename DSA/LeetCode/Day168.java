package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.* ;
public class Day168 {
    class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
       
        Map<String , List<String>> adjList = new HashMap<>();
        Map<String , Integer> indegree = new HashMap<>();
        for(int i = 0 ; i < recipes.length ; i++){
            String recipe = recipes[i];

            adjList.putIfAbsent(recipe , new ArrayList<>());
            for(String ingr : ingredients.get(i)){
                adjList.putIfAbsent(ingr , new ArrayList<>());
                adjList.get(recipe).add(ingr);
                adjList.get(ingr).add(recipe);

                indegree.put(recipe , indegree.getOrDefault(recipe , 0)+1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for(String supply : supplies){
            if(adjList.containsKey(supply))
            q.add(supply);
        }
        Set<String> finished = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                //traverse all the neighbors 
                String element = q.poll();
                if(adjList.containsKey(element))
                for(String parent : adjList.get(element)){
                    indegree.put(parent , indegree.getOrDefault(parent , 0)-1);
                    if(indegree.get(parent) == 0){
                        finished.add(parent);
                        q.add(parent);
                    }
                }
            }
        }
        List<String> ls = new ArrayList<>();
        for(String str : finished) ls.add(str);
        return ls ;
    }
}
}
