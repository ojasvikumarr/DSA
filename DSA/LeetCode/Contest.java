public class Contest {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        String Eq = "equilateral";
        String Scl = "scalene";
        String Iso = "isosceles";
        String none = "none";
        if (a + b <= c || b + c <= a || c + a <= b) {
            return none;
        } 
        if ((a == b && b != c) || (c == b && b != a) || (a == c && b != c)) {
            return Iso;
        } else if (a == b && b == c) {
            return Eq;
        } else{
            return Scl;
        }
    }

    public int fence (int[][] points){
        int count = 0 ;
        for(int i = 0; i< points.length ; i++){
            for(int j = i+1 ; j < points.length ; j++){
                int[] c = points[i];
                int[] t = points[j];

                if(c[0] < t[0] && c[i] < t[i]){
                    boolean valid = true ;
                    for(int[] point : points){
                        if(point != c && point != t && point[0] >= c[0] && point[0] <= t[0] && point[1] >= c[1] && point[1] <= t[1]){
                            valid = false ;
                            break ;
                        }
                    }
                    if(valid){
                        count++ ;
                    }
                }

                if(c[0] == t[0] || c[1] == t[1]){
                    boolean valid = true ;
                    for(int[] point : points){
                        if((point[0] > c[0] && point[0] < t[0] || point[0] < c[0] && point[0] >t[0]) &&
                        (point[1] > c[1] && point[1] < t[1] || point[1] < c[1] && point[1] > t[1])){
                            valid = false ;
                            break ;
                        }
                    }
                    if(valid){
                        count++ ;
                    }
                }
            }
        }
        return count ;
    }

    public int msOfSubarray(int[] nums, int k) {
        int mS = 0;
        int s = 0;
        int start = 0;
        int n = nums.length;

        for (int end = 0; end < n; end++) {
            s += nums[end];

            // Shrink the window until the absolute difference is k
            while (Math.abs(nums[end] - nums[start]) > k) {
                s -= nums[start];
                start++;
            }

            // Update mS if the current s is greater
            if (Math.abs(nums[end] - nums[start]) == k) {
                mS = Math.max(mS, s);
            }
        }

        return mS;
    }
    
}

// (a != b && b != c && c != a) 