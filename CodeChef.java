import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder; 
class Codechef {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int val1 = n*a ;
            int val2 = n*b ; 
            int val = 0 ; 
            if(n == 1){
                val = Math.max(a , b);
                sb.append(val);
            sb.append("\n");
                continue ;
            }
            if(n%2 == 0){
                //even a and b will be same 
                int zero = 0 ; 
                int one = 0 ; 
                int C = 0 ; 
                int D = 0 ; 

                for(int i = 0 ; i < n ;i++){
                    if(i%2 == 0){
                        //its a zero 
                        zero++ ;
                        D += one ;
                    }else{
                        one++ ; 
                        C += zero ; 
                    }
                }
                // System.out.println("Zero : " + zero + " One : " + one + " C : " + C + " D : " + D);
                // System.out.println("A : " + a + " B : " + b + " C : " + c + " D : " + d);
                val = a*(n/2) + b*(n/2) + Math.max(c , d)*C + Math.min(c , d)*D;
                int val3 = (a+b)*(n/2) + (Math.max(c , d)*(n*n)/4) + 0 ;
                val = Math.max(val , val3);
            }else{
                //odd a and b will be different
                int zero = 0 ; 
                int one = 0 ; 
                int C = 0 ; 
                int D = 0 ; 

                for(int i = 0 ; i < n ;i++){
                    if(i%2 == 0){
                        //its a zero 
                        zero++ ;
                        D += one ;
                    }else{
                        one++ ; 
                        C += zero ; 
                    }
                }
                // System.out.println("Zero : " + zero + " One : " + one + " C : " + C + " D : " + D);
                val = Math.max(a , b)*((n/2 )+ 1) + Math.min(a , b)*(n/2) + Math.max(c , d)*C + Math.min(c , d)*D;
                int val3 = (a+b)*(n/2) + (Math.max(c , d)*(((n*n)/4))) + 0 ;
                // System.out.println(val3);
                // if(d*(n/2) + b > c*(n/2) + a){
                    //     val3 += d*(n/2) + b ;
                    // }else{
                        //     val3 += c*(n/2) + a ;
                        // }
                        if(a > b){
                            val3 += a ;
                        }else {
                            val3 += b ;
                        }
                        val = Math.max(val , val3);
            }
            val = Math.max(val , Math.max(val1 , val2));
            
            sb.append(val);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static class Pair{
        int val ;
        int cost ; 
        public Pair(int val, int cost){
            this.val = val;
            this.cost = cost;
        }
    }
}
