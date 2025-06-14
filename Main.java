import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class Main {
static long[] basis;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        basis = new long[64]; 
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            long w = Long.parseLong(st.nextToken());
            graph.get(u).add(new Pair(v, w));
            // graph.get(v).add(new Pair(u, w)); 
        }

        long[] xor = new long[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
boolean[] parVis = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        // while (!q.isEmpty()) {
        //     int u = q.poll();
        //     for (Pair p : graph.get(u)) {
        //         int v = p.node ;
        //         int w = p.wt ;
        //         if (!visited[v]) {
        //             visited[v] = true;
        //             q.add(v);
        //             xor[v] = xor[u] ^ w;
        //         } else {
        //             insrt(xor[u] ^ xor[v] ^ w);
        //         }
        //     }
        // }
        // dfs(0, xor, visited, new boolean[n], graph);
        
        stack.push(0);
        while (!stack.isEmpty()) {
            int src = stack.peek();
            if (!visited[src]) {
                visited[src] = true;
                parVis[src] = true;
            }
            boolean pushed = false;
            for (Pair p : graph.get(src)) {
                int v = p.node;
                long w = p.wt;
                if (!visited[v]) {
                    xor[v] = (xor[src]^w);
                    stack.push(v);
                    pushed = true;
                    break;
                } else if (parVis[v]) {
                    insrt(xor[src] ^ xor[v] ^ w);
                }
            }
            if (!pushed) {
                parVis[src] = false;
                stack.pop();
            }
        }
        for(int i = 63 ; i >= 0 ; i--){
            for(int j = i -1 ; j >= 0 ; j--){
                if((basis[i]&(1L<<j)) != 0){
                    basis[i] ^= basis[j];
                }
            }
        }
        long minXor = minimum(xor[n-1]);
        if (visited[n-1] == false) {
            System.out.println(-1);
            return;
        }
        System.out.println(minXor);
        // sb.close();
        br.close();
    }
     static long minimum(long x) {
        for (int i = 63; i >= 0; i--) {
            if ((x^basis[i]) < x) {
                x =( x^basis[i]);
            }
        }
        return x;
    }
    static class Pair {
        int node;
        long wt;
        public Pair(int n, long w) {
            this.node = n;
            this.wt = w;
        }
    }
    static void insrt(long x) {
        for (int i = 63; i >= 0; i--) {
            if (((x>>i)&1) != 0){
            if (basis[i] == 0) {
                basis[i] = x;
                return;
            }
            x = (x^basis[i]);
            }
        }
    }
    
    public static void dfs(int src , long[] xor , boolean[] vis , boolean[] parVis , List<List<Pair>> graph){
        vis[src] = true ; 
        parVis[src] = true ;
        for(Pair p : graph.get(src)){
            int v = p.node ; 
            long w = p.wt ; 
            if(!vis[v]){
                xor[v] =( xor[src]^w) ; 
                dfs(v , xor , vis , parVis , graph);
            }else if(parVis[v]){
                insrt(xor[src] ^ xor[v] ^ w);
            }
        }
        parVis[src] = false ;
    }
}

