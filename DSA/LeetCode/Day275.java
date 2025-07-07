class Solution {
    public int maximumInvitations(int[] fav) {
        int n = fav.length;
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            rev.get(fav[i]).add(i);
        }
        // 1) find max cycle length > 2
        boolean[] seen = new boolean[n];
        int maxCycle = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                int cur = i, step = 0;
                Map<Integer,Integer> idx = new HashMap<>();
                while (!seen[cur]) {
                    seen[cur] = true;
                    idx.put(cur, step++);
                    cur = fav[cur];
                }
                if (idx.containsKey(cur)) {
                    int len = step - idx.get(cur);
                    maxCycle = Math.max(maxCycle, len);
                }
            }
        }
        // 2) mutual pairs chains sum
        int sumPairs = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int j = fav[i];
            if (i < j && fav[j] == i) {
                // mutual pair (i,j)
                int di = dfsDepth(rev, i, j);
                int dj = dfsDepth(rev, j, i);
                sumPairs += di + dj + 2;
                used[i] = used[j] = true;
            }
        }
        return Math.max(maxCycle, sumPairs);
    }
    // compute max depth in tree rooted at u, excluding block
    private int dfsDepth(List<List<Integer>> rev, int u, int block) {
        int maxd = 0;
        for (int v : rev.get(u)) {
            if (v == block) continue;
            maxd = Math.max(maxd, 1 + dfsDepth(rev, v, block));
        }
        return maxd;
    }
}