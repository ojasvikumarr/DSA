import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class ServerPCs {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Node[] pc = new Node[n];
        for(int i = 0 ; i < n ; i++){
            pc[i] = new Node(null , "");
        }
        Node server = new Node(null , "");

        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1){
                int p = Integer.parseInt(st.nextToken())-1;

                pc[p] = server;
            }else if(type == 2){
                int p = Integer.parseInt(st.nextToken())-1;
                String s = st.nextToken();

                pc[p] = new Node(pc[p] , s);
            }else{
                int p = Integer.parseInt(st.nextToken())-1;

                server = pc[p];
            }
        }
        Stack<String> stack = new Stack<>();
        Node curr = server ; 
        while(curr != null){
            if(curr.append.isEmpty() == false){
                stack.push(curr.append);
            }
            curr = curr.parent ;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        br.close();
    }
    static class Node{
        Node parent ; 
        String append ; 
        public Node(Node p , String a ){
            this.parent = p ; 
            this.append = a ; 
        }
    }
}









//  while(q-- > 0){
//             int idx = Integer.parseInt(st.nextToken());

//             if(arr[idx] == 1){
//                 //it will be 0 
//                 if(arr[idx+1] == 1 && arr[idx-1] == 1){
//                     comp++ ; 
//                 }else if(arr[idx+1] == 0 && arr[idx-1] == 0){
//                     comp-- ;
//                 }
//                 arr[idx] = 0 ; 
//             }else{
//                 if(arr[idx+1] == 0 && arr[idx-1] == 0){
//                     comp++ ;
//                 }else if(arr[idx+1] == 1 && arr[idx-1] == 1){
//                     comp-- ;
//                 }
//                 arr[idx] =
//             }
//             // if(arr[idx] == 0){
//             //     //it will be changed to 1 , comp will be added only if either side is 0
//             //     if((idx > 0 && arr[idx-1] == 1 ) && (idx < n-1 && arr[idx+1] == 1) || (idx == 0 && n > 1 && arr[idx+1] == 1) || (idx == n-1 && n > 1 && arr[idx-1] == 1)){
//             //         comp-- ;
//             //     }else if(n == 1 || ((idx > 0 && arr[idx-1] == 0 ) && (idx < n-1 && arr[idx+1] == 0)) || (idx == 0 && arr[idx+1] == 0) || (idx == n-1 && arr[idx-1] == 0)){
//             //         comp++ ; 
//             //     }
//             //     arr[idx] = 1 ;
//             // }else{
//             //     //it will be toggle to 0 , if both sides are nonzero , comp++ , if only one side is 0 comp same , if both zero comp-- 
//             //     if((idx > 0 && arr[idx-1] == 1 ) && (idx < n-1 && arr[idx+1] == 1) || (idx == 0 && n > 1 && arr[idx+1] == 1) || (idx == n-1 && n > 1 && arr[idx-1] == 1)){
//             //         comp++ ;
//             //     }else if(n == 1 || ((idx > 0 && arr[idx-1] == 0 ) && (idx < n-1 && arr[idx+1] == 0)) || (idx == 0 && arr[idx+1] == 0) || (idx == n-1 && arr[idx-1] == 0)){
//             //         comp-- ; 
//             //     }
//             //     arr[idx] = 0 ;
//             // }
//             sb.append(comp);
//             sb.append("\n");
//         }