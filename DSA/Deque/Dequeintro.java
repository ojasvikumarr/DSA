package Deque;



import java.util.LinkedList;
import java.util.*;
public class Dequeintro {
    public static void main( String args[]){
    Deque <Integer> d = new LinkedList<>();
    d.addFirst(1);
    d.addFirst(2);
    d.addLast(3);
    d.addLast(4);
    System.out.println(d);
    System.out.println(d.getFirst());
    d.removeFirst();
    System.out.println(d.getLast());
    System.out.println(d);

    }
}
