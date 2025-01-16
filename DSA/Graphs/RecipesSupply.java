package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.* ;
public class RecipesSupply {
    class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //We will be creating a graph out of the given ingredients 
        //we got recipes and thier neighbors ingredients 
        Map<String , List<String>> adjList = new HashMap<>();
        int n = recipes.length;

        //indegree Map 
        Map<String , Integer> indegree = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String recipe = recipes[i];
            adjList.putIfAbsent(recipe , new ArrayList<>());
            for(String ingre : ingredients.get(i)){
                //Creating bi-directional graph
                // adjList.get(recipe).add(ingre);
                adjList.putIfAbsent(ingre , new ArrayList<>());
                adjList.get(ingre).add(recipe);
                //indegree 
                indegree.put(recipe , indegree.getOrDefault(recipe , 0)+1);
            }
        }
        //Now we do BFS from the supplies we have 
        Queue<String> bfs = new LinkedList<>();
        for(String supply : supplies){
            if(adjList.containsKey(supply)){
                bfs.add(supply);
            }
        }
        List<String> result = new ArrayList<>();
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0){
                String curr = bfs.poll();
                for(String neighbor : adjList.get(curr)){
                    indegree.put(neighbor , indegree.get(neighbor)-1);
                    if(indegree.get(neighbor) == 0){
                        result.add(neighbor);
                        bfs.add(neighbor);
                    }
                }
            }
        }

        // for(String supply : supplies){
        //     result.remove(supply);
        // }
        return result ;

    }
    public List<String> findAllRecipesII(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        List<String> supply = new ArrayList<>();
        for(String str : supplies) supply.add(str);
        int n = recipes.length ; 
        int j = n ; 
        while(j-- > 0){
        for(int i = 0 ; i < n ; i++){
            boolean canBeMade = true ;
            for(String ingre : ingredients.get(i)){
                if(!supply.contains(ingre)){
                    canBeMade = false ; 
                    break ; 
                }
            }
            if(canBeMade == true && !result.contains(recipes[i])){
                supply.add(recipes[i]);
                result.add(recipes[i]);
            }
        }
        }
        return result ;
    }
}
}
