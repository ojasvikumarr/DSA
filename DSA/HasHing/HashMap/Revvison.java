package HasHing.HashMap;

import java.util.LinkedList;
import java.util.ArrayList ;

public class Revvison {
    static class HashMap<K,V>{
        class Node{
            K key ;
            V value ;
            Node (K key , V value){
                this.key = key ;
                this.value = value ;
            }
        }
        private int n ;//the no. of nodes in the array 
        private int N ;//No. of elements in the array 
        private LinkedList<Node> buckets[] ;//created an array of linkedlist called buckets

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldLL[] = buckets ;
            buckets = new LinkedList[N*2];
            N *= 2 ;
            for( int i = 0 ; i < oldLL.length ; i++ ){
                LinkedList<Node> ll = oldLL[i];
                for( int j = 0 ; j < ll.size() ; j++ ){
                    Node node = ll.remove();
                    put(node.key , node.value);
                }
            }
        }
        private int Hashfunction(K key){
            int h = key.hashCode() ;
            return (Math.abs(h)%N);
        }
        private int SearchinLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            for( int i = 0 ; i < ll.size() ; i++ ){
                Node newNode = ll.get(i);
                if( newNode == key ){
                    return i ;
                }
            }
            return -1;
        }
        public void put(K key , V value){
            int bi = Hashfunction(key);
            int di = SearchinLL(key , bi);
            if( di != -1 ){
                Node node = buckets[bi].get(di);
                node.value = value ;
            }
            else{
                buckets[bi].add(new Node(key , value));
                n++ ;
            }
            double lambda = (double) n/N ;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = Hashfunction(key);
            int di = SearchinLL(key , bi);
            if( di != -1 ){
                return true ;
            }
            else{
                return false ;
            }
        }
        public V remove(K key){
            int bi = Hashfunction(key);
            int di = SearchinLL(key , bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n-- ;
                return node.value ;
            }else{
                return null ;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for( int i = 0 ; i < buckets.length ; i++ ){
                LinkedList<Node> ll = buckets[i];
                for( Node n : ll){
                    keys.add(n.key);
                }
            }
            return keys ;
        }
        public boolean isEmpty(){
            return n == 0 ;
        }
    }
    
}
