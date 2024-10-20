import java.util.* ;

public class cp6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>() ;
            for(int i = 0 ; i < n ; i++) arr.add(sc.nextInt());
            String blacks = sc.next();

            helper(n , arr , blacks);
            System.out.println();
        }
        sc.close();
    }
    public static void helper(int n, ArrayList<Integer> arr, String black) {
        int[] coun = new int[n]; // Array to store computed coun for memoization
        Arrays.fill(coun, -1); // Initialize with -1 to indicate uncomputed coun
    
        for (int i = 0; i < n; i++) {
            if (coun[i] != -1) { // If the count is already computed, print and continue
                System.out.print(coun[i] + " ");
                continue;
            }
    
            int tar = arr.get(i);
            int idx = arr.get(i);
            int count = 0;
            ArrayList<Integer> visited = new ArrayList<>(); 
    

            while (arr.get(idx - 1) != tar) {
                visited.add(idx - 1); 
                if (black.charAt(idx - 1) == '0') count++;
                idx = arr.get(idx - 1);
            }
            if (black.charAt(idx - 1) == '0') count++;
            visited.add(idx - 1);
    
            // Store the computed count in all visited indices
            for (int v : visited) {
                coun[v] = count;
            }
    
            System.out.print(count + " ");
        }
    }
    
}
