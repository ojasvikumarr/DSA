package Queue;
import java.util.*;
import java.util.LinkedList ;
public class HW {
    
    //Given a number N.The task is to generate and print all binary number swith decimalvalues from 1 to N
    public static int DectoBin( int n ){
        int Bin = 0 ;
        int p = 0 ;
        while( n > 0 ){
            int lastdigit = n % 2 ;
            Bin += (lastdigit*Math.pow(10, p));
            n /= 2 ;
            p++ ;
        }
        return Bin ;
    }
    //We have an integer k and a queue of integers,we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative o

    public static void ReverseN(Queue<Integer> q , int k){
        Stack<Integer> s = new Stack<>();
        int i = 0 ;
        while( i<= k ){
            i++ ;
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        Queue<Integer> qq = new LinkedList<>();
        for( int j = 0 ; j <= q.size() - k + 2 ; j++){
            qq.add(q.remove());
        }
        while(!s.isEmpty()){
            q.add(qq.peek());
        }
    }
    public static void ReverseFirstN( Queue<Integer> q , int n ){
        if( n < 0 || n > q.size()){
            return ;
        }
        Stack<Integer> s = new Stack<>();
        for( int i = 0 ; i <= n ;i ++ ){
            s.push(q.remove());
        }
        while( !q.isEmpty()){
            q.add(q.remove());
        }
        while( !s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main ( String arg[]){
        Scanner sc = new Scanner (System.in);
        int n = 10 ;
        for( int i = 0 ; i <= n ; i++ ){
            System.out.println(DectoBin(i));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        //ReverseN(q, 4);
        ReverseFirstN(q, 4);
        while( !q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        sc.close();
    } 
}
