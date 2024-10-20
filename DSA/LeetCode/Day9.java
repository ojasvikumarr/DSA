import java.util.* ;

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Write your code here
        for(int i = 0 ; i < N-1 ; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length() , s2.length());
            for(int j = 0 ; j < len ; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                }
            }
        }

        //Now to do topological sort 
        //BFS approach 

        //Calculating the indeg
        int indeg[] = new int[K];
        for(int i = 0 ; i < adj.size() ; i++){
            for(int it : adj.get(i)){
                indeg[it]++ ;
            }
        }
        
        //Formation of QUeue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < indeg.length ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int[] order = new int[K];
        int i = 0 ;
        while(!q.isEmpty()){
            int curr = q.remove();
            order[i++] = curr ;
            for(int it : adj.get(curr)){
                indeg[it]-- ;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        String ans = "";
        for(int it : order){
            ans = ans + (char)(it + (int)'a');
        }
        return ans ;
    }
}