import java.util.* ;
public class Java2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.length ; i++){
            for(Integer node : graph[i]){
                adj.get(i).add(node);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < graph.length ; i++){
            if(adj.get(i).size() == 0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int elem = q.poll();
            ans.add(elem);
            for(int i = 0 ; i < graph.length ; i++){
                if(adj.get(i).contains(elem)){
                    q.add(i);
                }
            }
        }
        return ans;
    }

    public static char MaxFreq(String str){
        int[] freq = new int[26];
        for(int i = 0 ; i < str.length() ; i++){
            freq[str.charAt(i) - 'a']++ ;
        }
        int max = Integer.MIN_VALUE ;
        char c = 'a'; 
        for(int i = 0; i < 26 ; i++){
            if(max < freq[i]){
                max = freq[i];
                c += i;
            }
        }
        return c ;
    }


    //implementation of stack using array 

    public class stack{
        int[] arr ;
        int top ;
        int size ;
        public stack(int s){
            arr = new int[s];
            size = s ;
            top = -1 ;
        }
        //push operation 
        public void push(int val){
            top++ ;
            arr[top] = val ;
        }
        //pop operation 
        public int pop(){
            if(!isEmpty()){
                System.out.println("Your stack is empty!");
                return - 1; 
            }
            int del = arr[top];
            top-- ;
            return del ;
        }
        //size operation 
        public int size(){
            return top+1 ;
        }
        //isFull operation
        public boolean isFull(){
            return top+1 == size ;
        }
        //isEmpty operation
        public boolean isEmpty(){
            return top == -1 ;
        }
        //peek Operation 
        public int peek(){
            if(isEmpty()){
                System.out.println("Your Stack is empty!");
                return -1 ;
            }
            return arr[top];
        }
        //print operation 
        public void printAll(){
            if(!isEmpty()){
                System.out.println("The stack is empty!") ;
            }
            int t = top ; 
            while(t != -1){
                System.out.println(arr[t--]);
            }
        }
    }

    public static void reverseASentence(String str){
        Stack<String> st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            String word = "";
            while(str.charAt(i) != ' ' && i < str.length()){
                word += str.charAt(i++) ;
            }
            st.push(word);
        }
        StringBuilder ans = new StringBuilder(str);
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop() ;
        }
        System.out.println(ans);
    }
    public static void insertAtBottom(Stack<Integer> st , int elem){
        if(st.isEmpty()){
            st.push(elem);
            return ;
        }
        int top = st.peek();
        st.pop();
        insertAtBottom(st , elem);
        st.push(top);
    }

    public static void prefixEval(String s){
        Stack<Integer> st = new Stack<>();
        for(int i = s.length()-1 ; i >= 0 ;i--){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                st.push(s.charAt(i) - '0');
            }else{
                int op1 = st.peek();
                st.pop();
                int op2 = st.peek();
                st.pop();
                switch(s.charAt(i)){
                    case '+' : {
                        int sum = op1 + op2 ;
                        st.push(sum);
                        break ;
                    }
                    case '*' : {
                        int sum = op1 * op2 ;
                        st.push(sum);
                        break; 
                    }
                    case '/' : {
                        int sum = op1 / op2 ;
                        st.push(sum);
                        break; 
                    }
                    case '-' : {
                        int sum = op1 - op2 ;
                        st.push(sum);
                        break; 
                    }
                }
            }
        }
        System.out.println(st.peek());
    }
    //if it was a postfix expression
    //we would have just reversed the loop on the string 
    //AND in postfix reverse the order of subtraction and division as the order will be different in the postfix 

    public void infixTopostfix(String s){
        Stack<Character> st = new Stack<>();
        String ans = new String();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a' || s.charAt(i)>= 'A' && s.charAt(i) <= 'Z'){
                ans += (s.charAt(i));
            }else if(s.charAt(i) == '(' ) st.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != ')'){
                    ans += st.peek();
                    st.pop();
                }if(!st.isEmpty()) st.pop() ; // we'll pop the remaining ')'
            }else{
                while(!st.isEmpty() && prec(st.peek()) > prec(s.charAt(i))){
                    ans += st.peek();
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            ans += st.peek();
            st.pop();
        }
    }
    public int prec(char c){
        if(c == '^') return 0 ;
        else if(c == '*' || c == '/') return 1 ;
        else return 2 ;
    }


    //Queue implementaion using array 
    class queue{
        int[] arr;
        int front ;
        int back ;
        int size ; 
        public queue(int s){
            arr = new int[s];
            size = s ;
            front = 0 ; 
            back = -1 ;
        }
        //add operation
        public void add(int val){
            back++ ;
            arr[back] = val ;
        }
        //isFull operation
        public boolean isFull(){
            return back+1 == size ;
        }
        //isEmpty operation 
        public boolean isEmpty(){
            return front == back ;
        }
        //remove operation
        public void remove(){
            if(isEmpty()){
                System.out.println("Your queue is empty");
                return ;
            }
            front++ ;
        }
        //poll operation
        public int poll(){
            if(isEmpty()){
                System.out.println("Your queue is empty");
                return -1;
            }
            int rem = arr[front];
            front++ ;
            return rem ;
        }
    }

    //Queue implementation using stack
    class StacQue<T>{
        Stack<T> s ;
        Stack<T> p ;
        public StacQue(){
            s = new Stack<>();
            p = new Stack<>();
        }
        public void push(T val){
            s.push(val);
        }
        public T remove(){
            while(!s.isEmpty()){
                p.push(s.peek());
                s.pop();
            }
            T top = p.peek();
            p.pop();
            while(!p.isEmpty()){
                s.push(p.peek());
                p.pop();
            }
            return top ;
        }
        public boolean isEmpty(){
            return s.isEmpty();
        }
    }
    class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right ;
        public TreeNode(int val){
            this.val = val ;
            this.left = null ;
            this.right = null ;
        }
    }
    class Pair{
        TreeNode node  ; 
        int num  ;
        public Pair(TreeNode v , int n){
            this.node = v ;
            this.num = n ;
        }
    }
    public void AllOrders(TreeNode root){
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root , 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.num == 1){//this is about preorder #NLR
                pre.add(it.node.val);
                it.num++ ;
                st.push(it);
                if(it.node.left != null){
                    st.push(new Pair(it.node.left , 1));
                }
            }else if(it.num == 2){//this is about the inorder #LNR
                in.add(it.node.val);
                it.num++ ;
                st.push(it);
                if(it.node.right != null){
                    st.push(new Pair(it.node.right , 1));
                }
            }else{//this is about postorder #LRN
                post.add(it.node.val);
            }
        }
    }

    //rotate a matrix by 90
    public static void rotation90(int[][] matrix){
        //brute force will be to store the matrix in the dummy matrix and then copy its value based on the formula into the given matrix 
        //this will be n2 space and time 
        //better approach will be to transpose the matrix and reverse all the rows in it 
        //1st tranpose the matrix 
        //then reverse the rows in the matrix 
        int n = matrix.length , m = matrix[0].length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < m ; j++){
                swapMat(i , j , matrix);
            }
        }
        for(int i = 0 ; i < n ; i++){
            reverseRow(matrix[i]);
        }
    }
    public static void reverseRow(int[] row){
        int start = 0; 
        int end = row.length-1 ;
        while(start < end){
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp ;
            start++ ; end-- ;
        }
    }
    public static void spiralMatrix(int[][] matrix){
        int n = matrix.length , m = matrix[0].length ;
        int left = 0 ;
        int top = 0 ;
        int right = m-1;
        int bottom = n-1;
        ArrayList<Integer> ls = new ArrayList<>();
        while(left <= right && top <= bottom){
        for(int i = left ; i <= right ; i++){
            ls.add(matrix[top][i]);
        }
        top++ ;
        for(int i = top ; i <= bottom ; i++){
            ls.add(matrix[i][right]);
        }
        right-- ;
        if(left <= right){
        for(int i = right ; i >= left ; i--){
            ls.add(matrix[bottom][i]);
            }
            bottom-- ;
        }   
        if(top <= bottom){
            for(int i = bottom ; i >= top ; i--){
                ls.add(matrix[i][left]);
            }
            left++ ;
        }}
    
    }
    


    public static void majorityELment(int[] arr){
        int n = arr.length ;
        int d = n/3 ;
        //this states that any element more than n/3 should be contained in the answer 
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> ls = new ArrayList<>();
            if(arr[i] == -1){
                continue ;
            }
            int element = arr[i];
            for(int j = i ; j < n ; j++){
                if(arr[j] == element){
                    ls.add(arr[j]);
                    arr[j] = -1 ;
                }
            }
            if(ls.size() >= d){
                ans.add(ls.get(0));
            }
        }
        //O(n2) TC and O(N) SC
    }
    public static void majorityElement(int[] arr){
        int n = arr.length ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(arr[i] , map.getOrDefault(map, 0)+1);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) > n/3){
                ls.add(i);
            }
        }

        //This will be having O(nlogn) 
    }

    public static void sum3(int[] arr){
        int n = arr.length ;
        Set<List<Integer>> st = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(arr[k]);
                        Collections.sort(ls);
                        Collections.reverse(ls);
                        //therefore in descending order
                        st.add(ls);
                    }
                }
            }
        }
        //sorting is constant 
        //TC O(n3) SC O(n)
    }

    public static void opt3sum(int[] arr){
        int n = arr.length ;
        for(int i = 0 ; i < n ; i++){
            while(arr[i] == arr[i+1]) continue ;
            int j = i+1 ;
            int k = n-1 ;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++ ;
                }
                else if(sum > 0){
                    k-- ;
                }else{
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(arr[i]);ls.add(arr[j]);ls.add(arr[k]);
                    while( j < k && arr[j] == arr[j-1]) j++ ;
                    while( j < k && arr[k] == arr[k+1]) k-- ;
                }
            }
        }
    }
    public static void sum4 (int[] arr , int target){
        int n = arr.length ;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                Set<Long> set = new HashSet<>();
                for(int k = j+1 ; k < n ; k++){
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    long fourth = target - sum ;
                    if(set.contains(fourth)){
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add((int)fourth);
                        ls.add(arr[k]);
                        ans.add(ls);
                    }
                    set.add((long)arr[k]);
                }
            }
        }
    }
    public static void swapMat(int i , int j, int[][] matrix){
        int temp = matrix[i][j] ;
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp ;
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj , int[] visited , int[] pathVis , int node){
        visited[node] = 1 ;
        pathVis[node] = 1 ;
        for(Integer neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                detectCycle(adj, visited, pathVis, neighbor);
            }else if(pathVis[neighbor] == 1){
                return false ;
            }
        }
        pathVis[node] = 0 ;
        return true ;
    }

    public static void KahnAlgo(int[][] prerequisites , int numCourses){
        int vertices = numCourses ;
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        for(int i = 0 ;i < vertices ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i= 0 ; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        //this will form the graph in opposite order 
        //topological sort using kahnAlgo which uses BFS approach
        Queue<Integer> q = new LinkedList<>();
        //calculating indegrees 
        int[] indeg = new int[vertices];
        for(int i = 0 ; i < vertices ; i++){
            for(Integer node : adj.get(i)){
                indeg[node]++ ;
            }
        }
        //Now we'll be adding all the nodes with indeg as zero into the queue 
        for(int i = 0 ; i < vertices ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        //Now the Loop begins 
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int elem = q.poll();
            for(Integer neighbor : adj.get(elem)){
                indeg[neighbor]-- ;
                if(indeg[neighbor] == 0){
                    ans.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
    
    }

    public static int unboundedKnapsack(int[] val , int[] wt ,int idx , int W ){
        if(idx == 0){
            return (W/wt[0])*val[0];
        }
        // we got two options either steal or nosteal
        int nosteal = unboundedKnapsack(val, wt, idx-1, W);
        int steal = Integer.MIN_VALUE ;
        if(wt[idx] < W){
            steal = unboundedKnapsack(val, wt, idx, W - wt[idx]);
        }
        return Math.max(nosteal , steal) ;
    }


    //binary search to find sqrt of x
    public static long sqrt(int x){
        long l = 0 ,r = x ;
        while(l <= r){
            long mid = (l+r)/2 ;
            if(mid*mid <= x){
                l = mid+ 1 ;
            }else if(mid*mid > x){
                r = mid-1 ;
            }
        }
        return l ;
    }

    //koko problem
    public static int koko(int[] arr , int h){
        int max = Integer.MIN_VALUE ; 
        for(int elem : arr){
            max = Math.max(max , elem);
        }
        int l = 0 ; 
        int r = max ;
        while(l <= r){
            int mid = (l+r)/2 ;
            if(isSafe(arr , h , mid)){
                r = mid-1 ;
            }else{
                l = mid+1 ;
            }
        }
        return r ;
    }
    public static boolean isSafe(int[] arr , int h , int k){
        //we need to check is it possible to have the banans finished with h hours at the k rate 
        int hours = 0 ; 
        for(Integer elem : arr){
            hours += (elem+k-1)/k ;//this is a ciel function
            if(hours > h){
                return false ;
            }
        }
        return true ;
    }

    public static int unboundedKnapTab(int[] val ,int[] wt , int W){
        int n = wt.length ;
        int[][] dp = new int[n][W+1];
        //we know that at the last index the weight of th remaining element is divided by the remaining weight of the knapsack 
        //and is multiplied with its value thus the base case 
        //if(index == 0){
        //   return W/wt[0] * val[0]}
        for(int i = wt[0] ; i <= W ; i++){
            dp[0][i] = i/wt[0]*val[0];
        }
        //space optimization can be done 
        int[] second = new int[W+1];
        for(int i = 0 ; i <= W ; i++ ){
            second[i] = i/wt[0]*val[0];
        }
        for(int idx = 1; idx < n ; idx++){
            int[] first = new int[n];
            for(int cap = 0 ; cap <= W ; cap++){
                int nottake = second[cap];
                int take = Integer.MIN_VALUE ;
                if(wt[idx] <= cap){
                    take = second[cap-wt[idx]];
                }
                first[cap] = Math.max(take , nottake);
            }
            second = first ;
        }
        return second[W];
    }

    //ninja and his friends

    public static int dp(int i , int j1 , int j2 , int[][] grid , int n , int m , int[][][] dp){
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m){
            return (int)Math.pow(-10 , 9);
        }
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int maxi = Integer.MIN_VALUE ;
        for(int d1 = -1 ; d1 < 2 ; d1++){
            for(int d2 = -1 ; d2 < 2 ; d2++){
                int ans ;
                if(j1 == j2){
                    ans = grid[i][j1] + dp(i+1, j1+d1, j2+d2, grid, n , m, dp);
                }else{
                    ans = grid[i][j1] + grid[i][j2] + dp(i, j1+d1, j2+d2, grid, n , m, dp);
                }
                maxi = Math.max(ans , maxi);
            }
        }
        return maxi ;
    }
    //is teh string a palindrome 
    class Node{
        int val ;
        Node next ;
        public Node(int val){
            this.val = val ;
            this.next = null ;
        }
    }
    public static boolean palindrom(Node head){
        Node slow = head , fast = head; 
        while(fast!= null && fast.next.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
        }
        Node prev = null ;
        Node curr = head ;
        Node next ;
        while(curr != slow.next){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        while(slow != null && fast != null){
            if(slow.val != fast.val){
                return false ;
            }
            else{
                slow= slow.next ;
                fast = fast.next ;
            }
        }
        return true ;
    }
    public static boolean plain(Node head){
        Node temp = head ;
        Stack<Integer> st = new Stack<>();
        while(temp != null){
            st.push(temp.val);
            temp = temp.next ;
        }
        temp = head ;
        while(temp != null){
            if(temp.val != st.peek()){
                return false ;
            }
            st.pop();
            temp = temp.next ;
        }
        return true ;
    }
    public Node Add1(Node head){
        //firstly we'll be reversing the ll
        head = reverse(head);
        Node curr = head ;
        int carry = 1 ;
        while(curr != null){
            curr.val = curr.val + 1;
            if(curr.val < 10){
                carry = 0 ;
                break ;
            }else{
                curr = curr.next ;
            }
        }
        //that is a carry is there then we need to add a new node 
        head = reverse(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head ;
            return newNode ;
        }
        return head ;

    }
    public int helper(Node temp){
        if(temp == null){
            return 1 ;
        }
        int carry = helper(temp.next);
        temp.val = temp.val + carry ;
        if(temp.val == 10){
            temp.val = 0 ;
            return 1 ;
        }
        return 0 ;
    }
    public Node addition(Node head){
        int carry = helper(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head ;
            return newNode ;
        }
        return head ;
    }
    public static Node reverse(Node head){
        //we'll be reverseing the ll here 
        Node prev = null ;
        Node curr = head ;
        Node next ;
        while(curr != null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        return prev ;
    }

    //recursive solution to find out the length of the longest common subsequence problem 
    public int longestsub(String s1 , String s2 , int idx1 , int idx2 , int[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0 ;
        }
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + longestsub(s1, s2, idx1 - 1, idx2 - 1 , dp);
        }else{
            return dp[idx1][idx2] = Math.max(longestsub(s1, s2, idx1-1, idx2 , dp) , longestsub(s1, s2, idx1, idx2-1 , dp));
        }
    }
    public int longestsubtab(String s1 , String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //so what is teh base condition?
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        for(int i = 0 ; i <= s1.length() ; i++){
            dp[i][0] = 0 ;
        }
        for(int j = 0 ; j <= s2.length() ; j++){
            dp[0][j] = 0 ;
        }
        for(int i = 1 ; i <= s1.length() ; i++){
            for(int j = 1 ; j <=s2.length() ; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }
    //insertions in a binary search tree
    class TreeeNode{
        int val ;
        TreeeNode left ;
        TreeeNode right ;
        public TreeeNode(int val){
            this.val = val ;
            this.left = null ;
            this.right = null ;
        }
    }
    public TreeeNode insertion(TreeeNode root , int val){
        if(root == null){
            return new TreeeNode(val);
        }
        TreeeNode curr = root ;
        while(true){
            if(curr.val < val){
                if(curr.right != null){
                    curr = curr.right ;
                }else{
                    curr.right = new TreeeNode(val);
                    break ;
                }
            }else{
                if(curr.left != null){
                    curr = curr.left ;
                }else{
                    curr.left = new TreeeNode(val);
                    break ;
                }
            }
        }
        return root ;
    }

    class heap{
        int[] heap ;
        int size ;
        int maxsize ;
        public heap(int s){
            this.maxsize = s ;
            heap = new int[s+1];
            size = 0 ;
        }
    }
    public void heapify(int[] arr , int size , int i){
        int largest = i ;
        int left = 2*i ;
        int right = 2*i + 1;
        if(left < size && arr[i] < arr[left]){
            largest = left ;
        }if(right < size && arr[i] < arr[right]){
            largest = right ;
        }if(largest != i){
            swap(arr , largest , i);
            heapify(arr , size , largest);
        }
    }
    public void deletion(int[] arr){
        int size = arr.length-1 ;
        int i = 0 ;
        arr[i] = arr[size];
        //the first element is deleted 
        size--; 
        while(i < size){
            int leftchild = 2*i ;
            int rightchild = 2*i + 1;
            if(leftchild < size && arr[leftchild] > arr[i]){
                swap(arr , leftchild , i);
                i = leftchild ;
            }
            else if(rightchild < size && arr[rightchild] >arr[i]){
                swap(arr , rightchild , i);
                i = rightchild ;
            }else{
                return ;
            }
        }
    }
    public void insert(int[] arr , int val){
        // size = size+1 ;/
        int size = arr.length;
        arr[size] = val ;
        int i = size ;
        while(i > 1){
            int parent = i/2 ;
            if(arr[parent] < arr[i]){
                swap(arr , parent , i);
                i = parent ;
            }else{
                return ;
            }
        }

    }
    public void heapsort(int[] arr){
        int size = arr.length ;
        for(int i = size/2 ; i < size ; i++){
            heapify(arr , size , i);
        }
        //we know that leaves are present from size/2 to size 

    }
    public void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }
    public void postorder(TreeeNode root){
        Stack<TreeeNode> st1 = new Stack<>();
        Stack<TreeeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeeNode curr = st1.peek();
            st1.pop();
            st2.push(curr);
            if(curr.left != null){
                st1.push(curr.left) ;
            }
            if(curr.right != null){
                st2.push(curr.right);
            }
        }
        while(!st2.isEmpty()){
            //ans.add
        }
    }
    public void preorder(TreeeNode root){
        Stack<TreeeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            //ans.addst.top()
            //eifexist le ft psuh in st puch in st
        }
    }

    //boundary traversal 

    public List<Integer> boundaryAntiTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>() ;
        if(root.left == null && root.right == null){
              res.add(root.val);
              return res ;
        }
        leftBoundary(root, res);
        leafNodes(root, res);
        RightBoundary(root , res);
        return res ;
    }
    //Calculation leftBoundary 
    public void leftBoundary(TreeNode root , List<Integer> res){
        if(root.left == null && root.right == null){
            return ;
        }else{
            res.add(root.val);
            if(root.left != null) leftBoundary(root.left, res);
            if(root.right != null) leftBoundary(root.right, res);
        }
    }
    //Calculation RightBoundary 
    public void RightBoundary(TreeNode root , List<Integer> res){
        Stack<Integer> st = new Stack<>();
        while(root.left != null && root.right != null){
            st.push(root.val);
            if(root.right != null) root = root.right ;
            if(root.left != null) root = root.left ;
        }
        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }
    //Calculating leaf nodes
    public void leafNodes(TreeNode root , List<Integer> res){
        if(root.left == null && root.right == null){
            res.add(root.val);
            return ;
        }
        if(root.left != null){
            leafNodes(root.left, res);
        }
        if(root.right != null){
            leafNodes(root.right, res);
        }

    }
}


class Solution {
    public int minimumPushes(String Word) {
        HashMap<Character , Integer> map = new HashMap<>();
        int count = 0 ;
        char[] word = Word.toCharArray();
        for(Character c : word){
            count++ ;
            if(map.containsKey(c) == true){
                continue ;
            }else if(count <= 8){
                map.put(c , 1);
            }else if(count <= 16 && count > 8){
                map.put(c , 2);
            }else if(count <= 24 && count > 16){
                map.put(c , 3);
            }else{
                map.put(c , 4);
            }
        }
        int clicks = 0 ; 
        for(Character c : word){
            clicks += map.get(c);
        }
        return clicks; 
    }
}