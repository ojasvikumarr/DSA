package PlacementTime.AtCoders;

import java.util.Scanner;

public class LogicalFilling {
    public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int o = 0 ; 
            int q = 0 ; 
            StringBuilder sb = new StringBuilder(s);


            // 4 2
            // o???
            // 5 2
            // ?????
            // 7 3
            // .o???o.
            // 9 4
            // ?o???o?oo
            // 6 6
            // ??????
            // 3 1
            // ?.?

            // 19 9
            // .o.o.o????o.o.o????
            if(n >=2 && sb.charAt(0) == '?' && sb.charAt(1) == 'o'){
                sb.setCharAt(0, '.');
            } 
            if(n > 1 && sb.charAt(n-1) == '?' && sb.charAt(n-2) == 'o'){
                sb.setCharAt(n-1, '.');
            }
            for(int i = 0 ; i < n ; i++){
                if(sb.charAt(i) == '?' && i > 0 && i < n-1){
                    if(sb.charAt(i-1) == 'o' || sb.charAt(i+1) == 'o'){
                        //this will be a dot 
                        sb.setCharAt(i , '.');
                        continue ; 
                    }
                }
                if(sb.charAt(i) == '?'){
                    q++ ;
                }
                if(sb.charAt(i) == 'o'){
                    o++ ;
                }
            }

            // System.out.println(o+"--");


            if(q == k - o){
                //we dont have any option 
                for(int i = 0 ; i < n ; i++){
                    if(sb.charAt(i) == '?'){
                        sb.setCharAt(i, 'o');
                    }
                }
            }else if(k == o){
                for(int i = 0 ; i < n ; i++){
                    if(sb.charAt(i) == '?'){
                        sb.setCharAt(i, '.');
                    }
                }
            }else{
                //count odd blocks of question marks and even blocks of question marks 
                int i = 0 ; 
                int rem = k - o ; 
                
                int max = 0 ; 
                while(i < n){
                    int count = 0 ; 
                    while(i < n && sb.charAt(i) == '?'){
                        i++ ;
                        count++ ;
                    }
                    if(count%2 == 0){
                        //that its even 

                        max += count/2 ; 
                    }else{
                        //its odd 

                        max += (count+1)/2 ;
                    }
                    i++ ;
                }
                // System.out.println(max);
                if(rem == max){
                    //we need to make all the blocks that are odd to the pateren of o.o.o.o.o.o
                    i = 0 ; 
                    while(i < n){
                        int count = 0 ; 
                        int j = i ; 
                        while(i < n && sb.charAt(i) == '?'){
                            i++ ;
                            count++ ;
                        }
                        if(count%2 == 0){
                            //that its even 
                            //its even we need to make it ????
                            while(j < i){
                                sb.setCharAt(j , '?');
                                j++ ;
                            }
                        }else{
                            //its odd 
                            //we need to make o.o.o.o
                            boolean toggle = true ;
                            while(j < i){
                                if(toggle){
                                    sb.setCharAt(j , 'o');
                                    toggle = false ;
                                }else{
                                    sb.setCharAt(j , '.');
                                    toggle = true ;
                                }
                                j++ ; 
                            }
                        }
                        i++ ;
                    }
                }
            }
            System.out.println(sb.toString());
            sc.close();
        }
}
