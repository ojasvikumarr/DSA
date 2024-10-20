public class Day22 {
    public static int Helper(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return maxi;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + Helper(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }

    public static int NinjaTraining(int[][] points) {
        int[][] dp = new int[points.length][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 0; day < points.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[points.length - 1][3];
    }

    public static int OptTabulation(int[][] points){
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1] , points[0][2]);
        prev[1] = Math.max(points[0][0] , points[0][2]);
        prev[2] = Math.max(points[0][1] , points[0][0]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1] , points[0][2]));

        for(int day = 0 ; day < points.length ; day++){
            int[] temp = new int[4];
            for(int last = 0 ; last < 4 ; last++){
                for(int task = 0 ; task < 3 ; task++ ){
                    if(task != last){
                        temp[last] = Math.max(temp[last] , points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp ;
        }
        return prev[3];
    }
}
