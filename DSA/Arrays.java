import java.util.*;
public class Arrays {
    public static void update_arrays( int marks[] ){
        for ( int i = 1 ; i<=marks.length; i ++){
            marks[i]++;
        }
    }
    public static void main( String args[] ){
      //datatype arrayname[] = new datatype[size];
        int      marks[]     = new int     [5];
        try (//input/output
        Scanner sc = new Scanner(System.in)) {
            marks [0] = sc.nextInt() ; //maths
            marks [1] = sc.nextInt() ; //phy
            marks [2] = sc.nextInt() ; //chem
            marks [3] = sc.nextInt() ; //mec
        }
        System.out.println();
        System.out.println("marks of maths : "+marks[0]);
        System.out.println("marks of phy : "+marks[1]);
        System.out.println("marks of chem : "+marks[2]);
        System.out.println("marks of mec : "+marks[3]);

        marks [3] = 10;
        System.out.println("marks of mec : "+marks[3]);
        int percentage = ((marks[0]+marks[1]+marks[2]+marks[3])/4);
        System.out.println("percentagw achieved is : "+ percentage);
        System.out.println("The length of the array is: "+ marks.length);
        update_arrays(marks);
        for ( int i = 1; i<=marks.length ; i++){
        System.out.println("updated marks are : "+ marks[i]);
        System.out.println();
        }


    }
    public static void fill(int[] row, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fill'");
    }

}