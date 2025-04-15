package CodeForces;

import java.util.Scanner;

public class TriangelNRectangles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int x = sc.nextInt();
            int[] h1 = new int[x];
            for(int i = 0 ; i < x ; i++) h1[i] = sc.nextInt();
            int y = sc.nextInt();
            int[] h2 = new int[y];
            for(int i = 0 ; i < y ; i++) h2[i] = sc.nextInt();
            int z = sc.nextInt();
            int[] v1 = new int[z];
            for(int i = 0 ; i < z ; i++) v1[i] = sc.nextInt();
            int k = sc.nextInt();
            int[] v2 = new int[k];
            for(int i = 0 ; i < k ; i++) v2[i] = sc.nextInt();


            int m1 = h1[x-1] - h1[0];
            int m2 = h2[y-1] - h2[0];
            int m3 = v1[z-1] - v1[0];
            int m4 = v2[k-1] - v2[0];

            long M = Math.max(m1 , m2);
            long N = Math.max(m3 , m4);

            long res = Math.max(M*h , N*w);
            System.out.println(res);
        }
        sc.close();
    }
}
