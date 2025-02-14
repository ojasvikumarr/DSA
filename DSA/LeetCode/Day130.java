package LeetCode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.*; ;
public class Day130 {
    class ProductOfNumbers {
    ArrayList<Integer> ls ; 
    Queue<Integer> q ; 
    ArrayList<Integer> preProd ; 

    public ProductOfNumbers() {
        ls = new ArrayList<>();
        q = new LinkedList<>();
        preProd = new ArrayList<>();
    }
    
    public void add(int num) {
        ls.add(num);
        int m = preProd.size();
        if(m == 0 || preProd.get(m-1) == 0){
            preProd.add(num);
        }else{
            preProd.add(preProd.get(m-1) * num);
        }
        // System.out.println(preProd.get(preProd.size()-1));
        if(num ==  0){
            q.add(ls.size()-1); //constant
        }

    }
    
    public int getProduct(int k) {
        // int prod = 1 ;
        int n = ls.size();
        int idx = q.isEmpty() ? -1 : q.peek();
        // System.out.println(idx);
        int m = preProd.size();
        System.out.println((m-k-1 == -1 ? 0 : preProd.get(m-k-1)) + " " + (m-k-1) + " " + (n-k-1));
        if(idx != -1 && n-k-1 <= idx){
            return 0 ; 
        }else{
            int val = 0 ; 
            if(m-k-1 == -1){
                val = preProd.get(m-1);
            }else{
                val = preProd.get(m-1) / preProd.get(m-k-1);
            }
            // System.out.println(preProd.get(m-1) + " / " + preProd.get(m-k));
            return val ; 
        }
        // while(k > 0){
        //     prod *= ls.get(n - k);
        //     k-- ;
        // }
        // return prod ; 
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
}
