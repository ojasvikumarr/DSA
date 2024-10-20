package Stacks;


import java.util.*;

public class Stacks {
    static class Node {
        int data;
        Node next;
        public Stacks.Node head;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
        }
    }

    public static Node head;
    public static Node tail;

    // stacks made using linkedlists
    static class stack {
        static Node head = null;

        public boolean isEmpty() {
            return head == null;
        }

        // push
        public void push(int data) {
            Node newNode = new Node();
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.head = head;
            head = newNode;
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    static class stacks {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {// we used int as we need to store the removed value of the list and return it
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public int peek() {
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        stacks s = new stacks();
        s.push(1);
        s.push(2);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        stack ss = new stack();
        ss.push(1);
        ss.push(2);
        ss.push(3);
        while (!ss.isEmpty()) {
            System.out.println(ss.peek());
            ss.pop();
        }
        Stack<Integer> sss = new Stack<>();
        sss.push(1);
        sss.push(2);
        sss.push(3);
        while (!sss.isEmpty()) {
            System.out.println(sss.peek());
            sss.pop();
        }
    }
}