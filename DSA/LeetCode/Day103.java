package LeetCode;

public class Day103 {
    class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int n = derived.length ; 
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for(int i = 0 ; i < n-1 ; i++){
                if(derived[i] == 1){
                    //two options 01 or 10 
                    if(i == 0){
                        arr1[i] = 0 ; 
                        arr1[i+1] = 1;
                        arr2[i] = 1 ;
                        arr2[i+1] = 0 ;
                    }else{
                        arr1[i+1] = arr1[i] == 0 ? 1 : 0 ; 
                        arr2[i+1] = arr2[i] == 0 ? 1 : 0 ; 
                    }
                }else if(derived[i] == 0){
                    //two options 01 or 10 
                    if(i == 0){
                        arr1[i] = 0 ; 
                        arr1[i+1] = 0;
                        arr2[i] = 1 ;
                        arr2[i+1] = 1 ;
                    }else{
                        arr1[i+1] = arr1[i];
                        arr2[i+1] = arr2[i];
                    }
                }
            }
            //Now we just need to check 
            if((arr1[n-1]^arr1[0]) == derived[n-1] || (arr2[n-1]^arr2[0]) == derived[n-1]){
                return true ;
            }
            return false ;
        }
    }
}
