class Day271 {
    public char kthCharacter(long k, int[] ops) {
        int ans = 0 ; 
        int t  ; 
        while(k != 1){
            t = 63 - Long.numberOfLeadingZeros(k);
            if((1L<<t) == k){
                t-- ; 
            }
            k = k - (1L << t);
            if(ops[t] != 0){
                ans++ ;
            }
        }
        return (char)('a' + (ans%26));
    }

    public char kthCharacterII(long k, int[] ops) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        for(int i = 0 ; i < ops.length ; i++){
            int type = ops[i];
            if(type == 0){
                sb.append(sb.toString());
            }else{
                StringBuilder bs = new StringBuilder(sb.toString());
                for(int c = 0 ; c < bs.length() ; c++){
                    bs.setCharAt(c ,(char)('a'+(((bs.charAt(c) -'a') + 1)%26)) );
                }
                sb.append(bs.toString());
            }
            if(sb.length() >= k) break ;
        }
        // System.out.println(sb);
        return sb.charAt((int)(k-1));
    }
}