class Solution {
    public int climbStairs(int n) {
        // Base cases:
        // 1 stair -> 1 way
        // 2 stairs -> 2 ways
        if (n <= 2) {
            return n;
        }

        // dp[i] represents the number of ways to reach the ith stair
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[1] = 1;
        dp[2] = 2;

        // Build the solution from bottom to top
        for (int i = 3; i <= n; i++) {
            /*
             * To reach the ith stair:
             * 1. Take 1 step from (i-1)th stair
             * 2. Take 2 steps from (i-2)th stair
             *
             * Therefore:
             * dp[i] = dp[i-1] + dp[i-2]
             */
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // dp[n] contains the answer
        return dp[n];
    }
}
