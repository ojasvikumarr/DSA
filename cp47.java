import java.util.* ; 

public class cp47 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int Kx = sc.nextInt();
            int Ky = sc.nextInt();
            int Qx = sc.nextInt();
            int Qy = sc.nextInt();
            //No. of position of the knight that the king and queen be both be attacked 
            //King will have 8 possible positions for the knight  
            //Same with Queen will have 8 possible positions for the knight  
            //I need to fint he commomns in them 
            HashSet<String> set = new HashSet<>();
            int[][] dir = {{0 , a} , {0 , -a} , {a , 0} , {-a , 0}};
            for(int i = 0 ; i < 4 ; i++){
                int x = Kx + dir[i][0];
                int y = Ky + dir[i][1];
                if(dir[i][0] != 0){
                    //this means that the knight has moved in the x direction
                    //Thus the changes are to be done in the y direction 
                    y += b ; 
                    set.add(x + " " + y);
                    y -= 2*b ; 
                    set.add(x + " " + y);
                }else{
                    //this means that the knight has moved in the y direction 
                    //thus we will move in the x direction 
                    x += b ; 
                    set.add(x + " " + y);
                    x -= 2*b ; 
                    set.add(x + " " + y);
                }
            }
            //Now we just need to do the same thing with the wueen 
            // for(String key : set) System.out.print("(" +key + ") ");
            int result = 0 ; 
            // HashSet<String> QueenSeet = new HashSet<>();
            for(int i = 0 ; i < 4 ; i++){
                int x = Qx + dir[i][0];
                int y = Qy + dir[i][1];
                if(dir[i][0] != 0){
                    //this means that the knight has moved in the x direction
                    //Thus the changes are to be done in the y direction 
                    y += b ; 
                    if(set.contains(x+" "+ y)){
                        set.remove(x+" "+ y) ;
                        result++ ;
                    }
                    y -= 2*b ; 
                    if(set.contains(x+" "+ y)){
                        set.remove(x+" "+ y) ;
                        result++ ;
                    }
                }else{
                    //this means that the knight has moved in the y direction 
                    //thus we will move in the x direction 
                    x += b ; 
                    if(set.contains(x+" "+ y)){
                        set.remove(x+" "+ y) ;
                        result++ ;
                    }
                    x -= 2*b ; 
                    if(set.contains(x+" "+ y)){
                        set.remove(x+" "+ y) ;
                        result++ ;
                    }
                }
            }
            // System.out.println(result);
            solve(a , b , Kx , Ky , Qx , Qy);
        }
        sc.close();
    }

    public static void solve(int a , int b , int Kx , int Ky , int Qx , int Qy){
        int[][] dir = {{a , b} , {a , -b} , {-a , b} , {-a , -b} , {b , a} , {-b , a} , {b , -a} , {-b , -a}};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 8 ; i++){
            int x = Kx + dir[i][0];
            int y = Ky + dir[i][1];
            set.add(x+" "+y);
        }
        int result = 0 ; 
        for(int i = 0 ; i < 8 ; i++){
            int x = Qx + dir[i][0];
            int y = Qy + dir[i][1];
            if(set.contains(x+" "+y)){
                set.remove(x+" "+y);
                result++;
            }
        }
        System.out.println(result);
        return ; 
    } 
}
