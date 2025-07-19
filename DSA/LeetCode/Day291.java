class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> answer = new ArrayList<>();
        //We need to sort the array of string first so as to have folders ahead of folders with subfolders
        Arrays.sort(folder , (x, y) -> x.length() - y.length());
        Set<String> set = new HashSet<>();
        for(String str : folder){
            System.out.println(str);
            boolean contains = false ;
            for(int i = 0 ; i < str.length() ; i++){
                if(str.charAt(i) == '/' && i != 0){
                    if(set.contains(str.substring(0 , i))){
                        contains = true ;
                        break ;
                    }
                }
            }

            if(contains == false ){
                answer.add(str);
                set.add(str);
            } 
        }
        return answer ;
    }
}