package OA;

import java.util.*;

//problem 1
class Kaabil {
    static class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pairs {
        pair a;
        pair b;

        public Pairs(pair a, pair b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + a.x + "," + a.y + ") - (" + b.x + "," + b.y + ")";
        }
    }

    public static double distance(pair A, pair B) {
        return Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }

    public static void Generator(ArrayList<pair> A, ArrayList<pair> B, int m, int n) {
        for (int i = 0; i < m; i++) {
            A.add(new pair((int) (Math.random() * 10), (int) (Math.random() * 10)));
        }
        for (int i = 0; i < n; i++) {
            B.add(new pair((int) (Math.random() * 10), (int) (Math.random() * 10)));
        }
    }

    public static void main(String[] args) {
        ArrayList<pair> A = new ArrayList<>();
        ArrayList<pair> B = new ArrayList<>();
        int m = 100;
        int n = 90;
        Generator(A, B, m, n);
        ArrayList<Pairs> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance(A.get(i), B.get(j)) <= 8e-12) {
                    ans.add(new Pairs(A.get(i), B.get(j)));
                }
            }
        }
    }
}

// Would your solution work when m and n are large?
// Probably not as it is having time complexity of O(n^2) , thus might give time
// limit exceeded

// How can you make it work?
// one approach will be by serching for each coordinate of set A in set B using
// binary search
// First we will search for the x coordinate and then again do binary search for
// the y coordinate in the new set where x coordinate are same
// this will give us time complexity of O(nlogn)

// Can you give an approximate number for m and n?
// the can be of the order 10^7 because of O(nlogn)

// Can you make it work for m>>n.
// then we will just search for the coordinates of set b with n elements in set
// a with m elements

// Any other special situations that you can think of in which you could make it
// work?
// When dealing with floating-point coordinates, comparing distances with an
// epsilon value
// directly might not give accurate results due to floating-point precision
// issues. In such cases,
// you might need to use a approximate value instead of epsilon for comparison.
// as epsilon is too accurate for comparison thus an approx value when using
// float will help
