package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalI {
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                currentRow.add(binomialCoeff(row, col));
            }
            res.add(currentRow);
        }

        return res;
    }

    public int binomialCoeff(int n, int k) {
        int res = 1;
        k = Math.min(k, n - k);

        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }

        return res;
    }
}
}
