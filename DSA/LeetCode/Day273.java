class Solution {
    public String numberToWords(int num) {
        // tens hundred. thousands , 
        // 1 hundred 24 million
        // 1 billion 0 999 999 999 + 1
        // nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine worst case 
        // one ten hundred thousand million 
        // eleven , twelve , thirteen , fourteen , fifteen , sixteen , seventeen , eighteen , nineteen
        // two twenty 
        // three thirty
        // four fourty
        // five fifty
        // six sixty
        // seven seventy
        // eight eighty
        // nine ninety
        // ten 
        // 831 , 234 , 567
        // 10 ^ x , x == 0
        // x % 3 == 0 ,1 , 2
        // 7 , 7 --> seven 
        // 6 , 60 -> sixty 
        // 5 , 500 -> five hundred
        // 4 , 4000 -> four thousand
        // 3 , 30,000 -> thirty thousand 
        // 2 , 200,000 -> two hundred thousand
        // 1 , 1,000,000 -> one million
        // 3 , 30,000,000 -> thirty million
        // 8 , 800,000,000 -> eight hundred million
        // eight hundred thirty one million two hundred thirty four thousand five hundred sixty seven
        Map<Integer , String> map = new HashMap<>();
        map.put(1 , "one");
        map.put(2 , "two");
        map.put(3 , "three");
        map.put(4 , "four");
        map.put(5 , "five");
        map.put(6 , "six");
        map.put(7 , "seven");
        map.put(8 , "eight");
        map.put(9 , "nine");
        map.put(10 , "ten");
        map.put(11 , "eleven");
        map.put(12 , "twelve");
        map.put(13 , "thirteen");
        map.put(14 , "forteen");
        map.put(15 , "fifteen");
        map.put(16 , "sixteen");
        map.put(17 , "seventeen");
        map.put(18 , "eighteen");
        map.put(19 , "ninteen");
        map.put(20 , "tweenty");
        map.put(30 , "thirty");
        map.put(40 , "forty");
        map.put(50 , "fifty");
        map.put(60 , "sixty");
        map.put(70 , "seventy");
        map.put(80 , "eighty");
        map.put(90 , "ninety");
        map.put(100 , "hundred");
        map.put((int)1e3 , "thousand");
        map.put((int)1e6 , "million");
    }
    public String solve(int num , Map<Integer , String> map){
        int x = 0 ;
        boolean hundred = false ;
        boolean million = false ;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int digit = num%10 ; 
            num /= 10 ;
            int digit2 = -1; 
            if(num > 0) digit2 = num%10 ; 
            int mod = x%3 ;
            String s = map.get(digit*Math.pow(10 , x));
            if(x == 6){
                sb.insert( 0 , map.get((int)1e6)).appendFirst(" ");
            }else if(x == 3){
                sb.insert(0 , map.get((int)1e3)).appendFirst(" ");
            }
            if(mod == 2){
                sb.insert(0 , map.get(100)).appendFirst(" ");
            }
            sb.insert(0 , s).appendFirst(" ");
        }
    }

}