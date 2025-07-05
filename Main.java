import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];

            Map<Long , Integer> neg = new HashMap<>();
            Map<Long , Integer> po = new HashMap<>();
            int negs = 0 ; 
            int pos = 0 ; 

            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());
                if(arr[i] < 0){
                    arr[i] = -arr[i];
                    neg.put(arr[i] , neg.getOrDefault(arr[i] , 0)+1);
                    negs++ ; 
                }else{
                    po.put(arr[i] , po.getOrDefault(arr[i] , 0)+1);
                    pos++ ;
                }
            }


            Arrays.sort(arr);
            long r = arr[1]/arr[0];
            boolean flag = true ; 
            if(n > 2){
                long num = arr[1];
                long den = arr[0];
                for(int i = 1 ; i < n-1 ; i++){
                    if(arr[i+1]*den != arr[i]*num){
                        flag = false ; 
                        break ; 
                    }
                }
            }
            if(flag == false){
                sb.append("No");
                sb.append("\n");
                continue ;
            }

            if((pos == n || negs == n)){
                sb.append("Yes");
                sb.append("\n");
                continue ;
            }else{
                boolean flagA = true; 
                Map<Long , Integer> Apos = new HashMap<>(po);
                Map<Long , Integer> Aneg = new HashMap<>(neg);

                for(int i = 0 ; i < n ; i++){
                    long a = arr[i];
                    if(i%2 == 0){
                        int c = Apos.getOrDefault(a , 0);
                        if(c == 0){
                            flagA = false ; 
                            break ; 
                        }
                        Apos.put(a , c-1);
                    }else{
                        int c = Aneg.getOrDefault(a , 0);
                        if(c == 0){
                            flagA = false ; 
                            break ; 
                        }
                        Aneg.put(a , c-1);
                    }
                }
                boolean flagB = true; 
                Map<Long , Integer> Bpos = new HashMap<>(po);
                Map<Long , Integer> Bneg = new HashMap<>(neg);

                for(int i = 0 ; i < n ; i++){
                    long a = arr[i];
                    if(i%2 != 0){
                        int c = Bpos.getOrDefault(a , 0);
                        if(c == 0){
                            flagB = false ; 
                            break ; 
                        }
                        Bpos.put(a , c-1);
                    }else{
                        int c = Bneg.getOrDefault(a , 0);
                        if(c == 0){
                            flagB = false ; 
                            break ; 
                        }
                        Bneg.put(a , c-1);
                    }
                }

                if(flagA || flagB){
                    sb.append("Yes");
                }else{
                    sb.append("No");
                }
                sb.append("\n");
                continue ;
            }
            // if(neg.size() > 0 && flag ){
            //     //now assign neg values 
            //     if(neg.size() == 1){
            //         //that is toggling is happening 
            //         if(n%2 == 0){
            //             if(neg.get(arr[0]) != n/2){
            //                 flag = false ;
            //             }
            //         }else{
            //             //it can be n/2 or n/2 + 1
            //             if(neg.get(arr[0]) == n/2 || neg.get(arr[0]) == n/2 + 1){
            //                 flag = true ;
            //             }else{
            //                 flag = false ;
            //             }
            //         }
            //     }else{
            //         //toggle 
            //         if(neg.containsKey(arr[0])){
            //             for(int i = 0 ; i < n ; i += 2){
            //                 if(neg.get(arr[i]) == 0){
            //                     flag = false ; 
            //                     break ; 
            //                 }else{
            //                     neg.put(arr[i] , neg.get(arr[i]) - 1);
            //                 }
            //             }
            //             for(int key : neg.keySet()){
            //                 if(neg.get(key) > 0){
            //                     flag = false ; 
            //                     break ;
            //                 }
            //             }
            //         }else{
            //             for(int i = 1 ; i < n ; i += 2){
            //                 if(neg.get(arr[i]) == 0){
            //                     flag = false ; 
            //                     break ; 
            //                 }else{
            //                     neg.put(arr[i] , neg.get(arr[i]) - 1);
            //                 }
            //             }
            //             for(int key : neg.keySet()){
            //                 if(neg.get(key) > 0){
            //                     flag = false ; 
            //                     break ;
            //                 }
            //             }
            //         }
            //     }
            // }
           

            // if(flag){
            //     sb.append("Yes");
            // }else{
            //     sb.append("No");
            // }
            // sb.append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}





