package PriorityQueue;

//heap 
//--> it should a binary tree that is it must be having atmost 2 children
//--> CBT(Complet Binary Tree) is a BT in which all the levels are completely filled except the last level and the filling is done form left to right
//--> Heap Order property
//  * Children >= parent(MinHeap)
//  * Children <= parent(MaxHeap)

//when starting with idex as 1
//--> idx = i 
//--> leftchild = 2i + 1
//--> rightchild = 2i + 2

//when starting with idex as 0
//--> idx = i 
//--> leftchild = 2i  
//--> rightchild = 2i + 1
import java.util.ArrayList ;
public class L2 {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last idx ;
            arr.add(data);

            int x = arr.size()-1; //x is the child index
            int par = (x-1)/2; //[ parent index ]

            while(arr.get(x) < arr.get(par)){//O(log(n))
                // A tree with n Nodes will be having log(n) levels thus O(logn) time complexity
               //swap
               int temp = arr.get(x);
               arr.set(x , arr.get(par));
               arr.set(par,temp); 

               x = par ;
               par = (x-1)/2 ;
            }
        }

        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i + 1 ;
            int right = 2*i + 2;
            int minIdx = i ;

            if(left <arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left ;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right ;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i , arr.get(minIdx));
                arr.set(minIdx , temp);

                heapify(minIdx);
            }
        }
            public int remove(){
            int data = arr.get(0);

            //step1 : Swap the last with the first
            int temp = arr.get(0);
            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            //step2 : Delete last
            arr.remove(arr.size() - 1);

            heapify(0);
            return data ;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
        }
    static class MaxHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last idx ;
            arr.add(data);

            int x = arr.size()-1; //x is the child index
            int par = (x-1)/2; //[ parent index ]

            while(arr.get(x) > arr.get(par)){//O(log(n))
                // A tree with n Nodes will be having log(n) levels thus O(logn) time complexity
               //swap
               int temp = arr.get(x);
               arr.set(x , arr.get(par));
               arr.set(par,temp); 

               x = par ;
               par = (x-1)/2 ;
            }
        }

        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i + 1 ;
            int right = 2*i + 2;
            int minIdx = i ;

            if(left <arr.size() && arr.get(minIdx) < arr.get(left)){
                minIdx = left ;
            }
            if(right < arr.size() && arr.get(minIdx) < arr.get(right)){
                minIdx = right ;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i , arr.get(minIdx));
                arr.set(minIdx , temp);

                heapify(minIdx);
            }

        }
        public int remove(){
            int data = arr.get(0);

            //step1 : Swap the last with the first
            int temp = arr.get(0);
            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            //step2 : Delete last
            arr.remove(arr.size() - 1);

            heapify(0);
            return data ;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String args[]){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(2);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
