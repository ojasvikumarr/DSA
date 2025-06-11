import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp108 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a= new int[n];
            for(int i = 0 ; i < n ; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            int[] c = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                c[i] = Integer.parseInt(st.nextToken());
            }

            int[] A = new int[3];
            A[0] = -1 ;
            int[] B = new int[3];
            B[0] = -1 ;
            int[] C = new int[3];
            C[0] = -1 ;

            for(int i = 0 ; i < n ; i++){
                if(A[0] == -1 || a[A[0]] < a[i]){
                    A[2] = A[1];
                    A[1] = A[0];
                    A[0] = i;
                }else if(A[1] == -1 || a[A[1]] < a[i]){
                    A[2] = A[1];
                    A[1] = i;
                }else if(A[2] == -1 || a[A[2]] < a[i]){
                    A[2] = i;
                }
                if(B[0] == -1 || b[B[0]] < b[i]){
                    B[2] = B[1];
                    B[1] = B[0];
                    B[0] = i;
                }else if(B[1] == -1 || b[B[1]] < b[i]){
                    B[2] = B[1];
                    B[1] = i;
                }else if(B[2] == -1 || b[B[2]] < b[i]){
                    B[2] = i;
                }
                if(C[0] == -1 || c[C[0]] < c[i]){
                    C[2] = C[1];
                    C[1] = C[0];
                    C[0] = i;
                }else if(C[1] == -1 || c[C[1]] < c[i]){
                    C[2] = C[1];
                    C[1] = i;
                }else if(C[2] == -1 || c[C[2]] < c[i]){
                    C[2] = i;
                }
            }
            int maxi = 0 ;
            for(int aa : A){
                for(int bb : B){
                    for(int cc : C){
                        if(aa != bb && bb != cc && aa != cc){
                            maxi = Math.max(maxi , a[aa] + b[bb] + c[cc]);
                        }
                    }
                }
            }
            sb.append(maxi).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}

