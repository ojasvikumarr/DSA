import java.util.* ;
public class codeforces {
    public static void main (String[] args) 
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt() ;
            int m = sc.nextInt() ;
            List<List<Integer>> matrix = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                matrix.add(new ArrayList<>());
                for(int j = 0 ; j < m ; j++){
                    matrix.get(i).add(sc.nextInt());
                }
            }

            solve(matrix);
		}
		sc.close();
	}
    public static void solve(List<List<Integer>> matrix){
        //I need the cow order 
        int n = matrix.size(); 
        int m = matrix.get(0).size();
        List<int[]> order = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            order.add(new int[]{i , matrix.get(i).get(0)});
        }

        for(List<Integer> row : matrix){
            Collections.sort(row);
        }
        Collections.sort(matrix , (a , b) -> a.get(0) - b.get(0));
        
        int maxi = -1 ; 
        for(int j = 0 ; j < m ; j++){
            for(int i = 0 ; i < n ; i++){
                if(maxi > matrix.get(i).get(j)){
                    System.out.println(-1);
                    return ;
                }
                maxi = matrix.get(i).get(j);
            }
        }

        Collections.sort(order , (a , b) -> (a[1] - b[1]));
        for(int[] it : order){
            System.out.print(it[0]+1+" ");
        }
        System.out.println();
        return ; 
    }
}
