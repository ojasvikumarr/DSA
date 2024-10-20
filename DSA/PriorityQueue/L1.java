package PriorityQueue;
// import java.util.Comparator;
import java.util.PriorityQueue ;

public class L1 {
    // add() --> O(logn)
    // remove() --> O(logn)
    // peek() ---> O(1)
    static class Student implements Comparable<Student>{//function overriding 
        String name ;
        int rank ;
        
        public Student(String name  , int rank){
            this.name = name ;
            this.rank = rank ;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank ;
            //as we know that this.rank is an object and s2.rank is also an object thus thie neg
            //negative sign is really subtracting their ranks
            //when this return statement will give a more negative value or a small value them that object will get higher priority 
            //thus when return is negative that means 
            //this.rank is smaller than s2.rank 
            //thus this.rank is getting higher priority than s2.rank 
        }
    }
    public static void main(String args[]){
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A" , 4));//O(logn)
        pq.add(new Student("B" , 5));
        pq.add(new Student("C" , 2));
        pq.add(new Student("D" , 8));
        pq.add(new Student("E" , 9));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> "+ pq.peek().rank);//O(1)
            pq.remove();//O(logn)
        }

    }
}




