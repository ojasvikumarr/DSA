import java.util.* ; 
public class cp18 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0 ; i < n ; i++) a[i] = sc.nextInt();
            for(int i = 0 ; i < n ; i++) b[i] = sc.nextInt();
            if(solve(a , b , n)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static boolean solve(int[] a , int[] b , int n){
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            setA.add(a[i]);
            setB.add(b[i]);
        }
        if(setA.size() >= 3 || setB.size() >= 3) return true ; 

        if(setA.size() == 1 && setB.size() <= 2 || setA.size() <= 2 && setB.size() == 1) return false ; 
        if(setA.size() == 2 && setB.size() == 2){
            //check elements 
            //ye pta hai ki do hi hai elements 
            //agar ek ki bhi freq 1 hui toh dikkat 
            //hume ek array mein 
            if(!setA.equals(setB)){
                return true ; 
            }else {
                //check with freq 
                //koi bhi ek pkad lo 
                int ele = a[0];
                int freqA = 0 ; 
                int freqB = 0 ; 
                for(int i = 0 ;i < n ; i++){
                    if(a[i] == ele){
                        freqA++ ;
                    }
                    if(b[i] == ele){
                        freqB++ ; 
                    }
                }
                if(freqA == freqB && freqA == 1){
                    return false ; 
                }else{
                    return true ; 
                }

            }
        }

        return false ;
    }
}
