class Day267 {
    public int possibleStringCount(String s) {
        int count = 0 ;
        for(int i = 0 ; i < s.length()-1 ; i++){
            if(s.charAt(i) == s.charAt(i+1)) count++ ;
        }
        //hello
        return count + 1 ;
    }
}