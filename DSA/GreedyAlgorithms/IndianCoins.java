package GreedyAlgorithms;

public class IndianCoins {
    public static void main ( String args[]){
        int Denominations[] = { 2000 , 500 , 200 , 100 , 50 , 20 , 10 , 5 , 2 , 1 };
        int Value = 989 ; 
        int notes = 0 ; 
        for(int i = 0 ; i < Denominations.length ; i++){
            if( Value >= Denominations[i]){
                notes++ ;
                Value -= Denominations[i];
                System.out.print(+Denominations[i]+" , ");
            }
        }
        System.out.println();
        System.out.println("The minimum combination of notes will be " + notes );
    }
}
