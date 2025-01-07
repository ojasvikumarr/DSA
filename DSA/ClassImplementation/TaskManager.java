package ClassImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TaskManager {

    //Map sirf taskId se task ko access karne ke liye tha 
    //TreeMap se logn time mein task ko priority ke basis pe sort rakha 

    //PQ mein removal mein bohot time lag jata 
    class Task implements Comparable<Task>{
        int userId ; 
        int taskId ; 
        int priority ; 
        public Task(int u , int t , int p){
            this.userId = u ; 
            this.taskId = t ; 
            this.priority = p ; 
        }

        @Override 
        public int compareTo(Task that){
            if(this.priority == that.priority){
                return that.taskId - this.taskId ;
            }
            return that.priority - this.priority ;
        }
    }

    List<Task> pq ;
    Map<Integer , Task> map ;
    TreeMap<Task, Integer> treeMap ;
    public TaskManager(List<List<Integer>> tasks) {
        //Contains the data structure 
        // pq = new ArrayList<>();
        map = new HashMap<>();
        treeMap = new TreeMap<>();
        for(List<Integer> tuple : tasks){
            // pq.add(new Task(tuple.get(0) , tuple.get(1) , tuple.get(2)));
            map.put(tuple.get(1) , new Task(tuple.get(0) , tuple.get(1) , tuple.get(2)));
            treeMap.put(new Task(tuple.get(0) , tuple.get(1) , tuple.get(2)) , tuple.get(1));
        }
    }
    
    public void add(int u, int t, int p) {
        //Unique TaskIDs right so can use a list 
        // pq.add(new Task(u , t , p));
        treeMap.put( new Task(u , t , p) , t );
        map.put(t , new Task(u , t , p));
    }
    
    public void edit(int taskId, int newPriority) {
        //Priority updation 
        // int user = map.get(taskId).userId;
        // int priority = map.get(taskId).priority;
        // map.put(taskId , new Task(user , taskId , newPriority));
        // for(int i = 0 ; i < pq.size() ; i++){
        //     Task t = pq.get(i);
        //     if(t.taskId == taskId){
        //         pq.remove(i);
        //         pq.add(new Task(user , taskId , newPriority));
        //         return ;
        //     }
        // }

        Task task = map.get(taskId);
        if(task != null){
            treeMap.remove(task);
            task.priority = newPriority ; 
            treeMap.put(task , task.userId);
        }
    }
    
    public void rmv(int taskId) {
        //Deleting the tuple of taskId 
        Task task = map.get(taskId);
        if(task != null){
            map.remove(taskId);
            treeMap.remove(task);
        }
        // for(int i = 0 ; i < pq.size() ; i++){
        //     if(pq.get(i).taskId == taskId){
        //         pq.remove(i);
        //         break ; 
        //     } 
        // }
    }
    
    public int execTop() {
        //executes the task with the highest priority
        // Collections.sort(pq , (a , b) -> {
        //     if(b.priority == a.priority){
        //         return b.taskId - a.taskId ; 
        //     }
        //     return b.priority - a.priority;
        // });
        // if(pq.size() == 0) return -1 ;
        // int maxi = 0 ; 
        // int tId = -1 ;
        // int uId = -1 ;
        // for(int i = 0 ; i < pq.size() ; i++){
        //     if(maxi < pq.get(i).priority){
        //         uId = pq.get(i).userId ;
        //         maxi = pq.get(i).priority;
        //         tId = pq.get(i).taskId;
        //     }else if(maxi == pq.get(i).priority && tId < pq.get(i).taskId){
        //         tId = pq.get(i).taskId ; 
        //         uId = pq.get(i).userId ;
        //     }
        // }
        
        // // int taskId = pq.get(0).taskId ;
        // // int userId = pq.get(0).userId ;
        // //taskId is removed from the system
        // // int user = map.get(taskId).userId ; 
        // map.remove(tId);
        // for(int i = 0 ; i < pq.size() ; i++){
        //     Task t = pq.get(i);
        //     if(t.userId == uId && t.taskId == tId && t.priority == maxi){
        //         pq.remove(i);
        //     }
        // }
        // // pq.remove(0);
        // //And return userID witht he associated taskid
        // return uId ;
        if(treeMap.isEmpty()){
            return -1 ;
        }
        Task task = treeMap.firstKey();
        treeMap.remove(task);
        map.remove(task.taskId);
        return task.userId ;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
