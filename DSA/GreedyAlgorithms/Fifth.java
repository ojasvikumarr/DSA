package GreedyAlgorithms;
import java.util.* ;
public class Fifth {
    public static void main(String args[]){
        int V = 121 ;
        Integer money[] = { 2000 , 500 , 100 , 50 , 20 , 10 , 5 , 2 , 1};
        Arrays.sort(money , Comparator.reverseOrder());
        int count = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();//dynamic array 

        for( int i = 0 ; i < money.length ; i++){
            if( V >= money[i] ){
                while( V >= money[i]){
                    V -= money[i];
                    count ++ ;
                    ans.add(money[i]);
                }
            }
        }
        System.out.println("Total coins used : "+ count);
        for( int i = 0 ; i < ans.size() ; i++ ){
            System.out.print(ans.get(i)+" ");
        }
    }
}
