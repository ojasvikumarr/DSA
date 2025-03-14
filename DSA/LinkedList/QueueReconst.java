package LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.* ; 

public class QueueReconst {
    class Solution {
    class Node{
        int h ; 
        int k ; 
        Node next ; 
        public Node(int h ,int k){
            this.h = h; 
            this.k = k ;  
            this.next = null ; 
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people , (a, b)->{
            if(a[0] != b[0]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        List<int[]> res = new LinkedList<>();
        for(int[] curr : people){
            res.add(curr[1] , curr);
        }
        return res.toArray(new int[people.length][]);
    }
    public int[][] reconstructQueueII(int[][] people) {
        Arrays.sort(people , (a , b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        Node root = new Node(-1 , -1);
        for(int[] person : people){
            int h = person[0];
            int k = person[1];
            //now we traverse the linkedlist 
            Node temp = root ; 
            Node newNode = new Node(h , k);
            while(temp != null){
                if(k == 0){
                    while(temp != null && temp.next != null && temp.h < h) temp = temp.next ; 
                    if(temp.next != null){
                        //that is we have a list ahead to be saved 
                        newNode.next = temp.next ; 
                    }
                    temp.next = newNode; 
                    break ; 
                }
                temp = temp.next ; 
                while(temp != null && temp.next != null && temp.h >= h){
                    temp = temp.next ;
                    k-- ; 
                }
                while(temp != null && temp.next != null && temp.h < h) temp = temp.next ; 
            }

        }
        Node tem = root ; 
        int[][] res = new int[people.length][2];
        int i = 0 ; 
        while(tem.next != null){
            tem = tem.next ; 
            System.out.println(tem.h + " " + tem.k);
            res[i++] = new int[]{tem.h , tem.k};
        }
        return res ;
    }
}
}
