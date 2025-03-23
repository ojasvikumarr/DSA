package PlacementTime.Infosys;
import java.util.*; 

public class Herosandvillans {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int h = sc.nextInt();
        int H = sc.nextInt();
        int[] villans = new int[v];
        int removal = 0 ; 

        for(int i = 0 ; i < v ; i++){ 
            villans[i] = sc.nextInt();
            if(villans[i] > H){
                villans[i] = -1 ; 
                removal++ ; 
            }
        }
        long sum = 0 ; 
        List<Integer> ls = new ArrayList<>() ;
        for(Integer vill : villans){
            if(vill != -1){
                ls.add(vill);
                sum += vill;
            } 
        }

        if(sum <= H*h && ls.size() <= h){
            System.out.println(removal);
        }else{
            solve(ls, removal, h, H);
        }

        sc.close();
    }
    public static void solve(List<Integer> ls , int v , int h , int H){
        Collections.sort(ls);
        //we have h number of villians 
        int hero = H*h ; 
        int i = 0 ; 
        while(i <ls.size()){
            int sum = 0 ; 
            while(i < ls.size() && sum < H){
                sum += ls.get(i) ;
                i++ ; 
            }
        }
        if(i != ls.size()-1){
            System.out.println(ls.size()-i);
        }else{
            System.out.println(0);
        }
    }
}
