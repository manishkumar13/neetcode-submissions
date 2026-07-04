class Solution {
    public int climbStairs(int n) {
        // dp[i] stores the number of ways to reach the ith stair.
        // A value of 0 means it has not been computed yet.
        int[] dp = new int[n + 1];

        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        // Base case:
        // 1 stair -> 1 way
        // 2 stairs -> 2 ways
        if (n <= 2) {
            return n;
        }

        // If already computed, return the cached result
        if (dp[n] != 0) {
            return dp[n];
        }

        /*
         * To reach the nth stair:
         * 1. Take 1 step from (n-1)th stair
         * 2. Take 2 steps from (n-2)th stair
         *
         * Therefore:
         * ways(n) = ways(n-1) + ways(n-2)
         */
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }
}
