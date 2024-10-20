import java.util.* ;

public class cp4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt();
            System.out.println(HelperB(n));
        }
        sc.close();
    }
    public static int Helper(int n  , int[] arr){
        Map<Integer , Integer> map = new HashMap<>() ;
        for(Integer it : arr){
            map.put(it , map.getOrDefault(it,0)+1);
        }
        int maxi = 0 ; 
        for(Integer key : map.keySet()){
            maxi = Math.max(maxi , map.get(key));
        }
        return n - maxi ;
    }
    public static int HelperB(int n){
        if(n == 1) return 1 ;
        return -1 ;
    }

    public static void HelperD(int n , int[] arr){
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        recur(0 , arr , all , new ArrayList<>());   
        Collections.sort(all , (x , y) -> y.size() - x.size());
        int size = all.get(0).size();
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < size ; i++){
            if(all.get(i).size() == size){
                ArrayList<Integer> temp = new ArrayList<>(all.get(i));
                for(int j = 0 ; j < all.size() ; j++){
                    if(i % 2 == 0){
                        max = Math.max(temp.get(i) , max);
                    }else{
                        min = Math.min(temp.get(i) , min);
                    }
                }   
            }
        }
    }
    public static void recur(int idx , int[] arr , ArrayList<ArrayList<Integer>> all , ArrayList<Integer> ls , Set<Integer> usedElements){
        if(idx == arr.length){
            all.add(new ArrayList<>(ls));
            return ;
        }
        for(int i = idx ; i < arr.length ; i++){
            if(i > ide)
            if(usedElements.constainsKey(arr[idx])){
                ls.add(arr[idx]);
                recur(idx+1, arr, all, ls, usedElements);
                ls.remove(ls.size()-1);
                recur(idx+1, arr, all, ls, usedElements);
            }

        }
    }
}
