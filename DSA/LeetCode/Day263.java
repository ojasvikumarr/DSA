class Day263 {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int onesPicked = 0;
        long value = 0;
        long pow = 1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                count++;
            } else {
                if (pow <= k && value + pow <= k) {
                    value += pow;
                    count++;
                    onesPicked++;
                }
            }

            // Update pow only if it doesn't exceed k to avoid overflow
            if (pow <= k) pow *= 2;
        }

        return count;
    }
}