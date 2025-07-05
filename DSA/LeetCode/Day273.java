class Day273 {
    public int findLucky(int[] arr) {
        TreeMap<Integer , Integer> map = new TreeMap<>();
        int n = arr.length ;
        for(int i = 0 ;i < n ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        int result = -1;
        for(int key : map.keySet()){
            if(map.get(key) == key){
                result = key ;
            }
        }
        return result ; 
    }
}