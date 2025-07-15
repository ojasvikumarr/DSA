class Day287 {
    public boolean isValid(String word) {
        Set<Character> set = new HashSet<>(Arrays.asList('a' , 'e' , 'i' , 'o' , 'u' , 
                                                         'A' , 'E' , 'I' , 'O' , 'U'));

        if(word.length() < 3){
            return false ;
        }

        boolean vowel = false ; 
        boolean consonant = false ;
        for(char c : word.toCharArray()){
            if(set.contains(c)){
                vowel = true ;
            }else if( c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z'){
                consonant = true ;
            }
            if( c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z' || 
                c >= '0' && c <= '9'){
                continue ;
            }else{
                return false ;
            }
        }
        if(vowel && consonant){
            return true ;
        }else{
            return false ;
        }
    }
}