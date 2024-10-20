//import java.util.*;

public class SpiralMatrix{
    public static void Spiral(int matrix[][]){
        int Startrow = 0;
        int Endrow = matrix.length-1;
        int StartCol = 0;
        int EndCol = matrix[0].length-1;
        while(Endrow>=Startrow && EndCol>=StartCol){//this && is used so as to use it for nXm matrix also and not only nXn
        //top
        for ( int j =StartCol+1 ; j<=EndCol ; j++){
            System.out.print(matrix[Startrow][j]+" ");
        }
        //right
        for ( int i =Startrow+1 ; i<=Endrow ; i++){
            System.out.print(matrix[i][StartCol]+" ");
        }
        //bottom
        for( int j =EndCol-1 ; j>=StartCol ;j--){
            //we are doing this so that in odd boundry matrix the cell at the centre will also be printed but only
            //one time and it will not be printed two times as it falls in both top and bottom loop
            if(Startrow == Endrow){
                break;
            }
            System.out.print(matrix[Endrow][j]+" ");
        }
        //left
        for( int i =Endrow-1 ; i>=Startrow ;i--){
             //we are doing this so that in odd boundry matrix the cell at the centre will also be printed but only
            //one time and it will not be printed two times as it falls in both left and right loop
            if(StartCol == EndCol){
                break;
            }
            System.out.print(matrix[i][EndCol]+" ");
        }
        StartCol++;
        Startrow++;
        Endrow--;
        EndCol--;
    }
    System.out.println();
    }
    public static void main ( String args[] ){
        int Matrix[][]={{1,2,3,4},{5,6,7,8},
                        {9,10,11,12},{13,14,15,16}};
        Spiral(Matrix);
    }
}