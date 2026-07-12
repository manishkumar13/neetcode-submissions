class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start from step 0 or step 1
        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }

    // Returns minimum cost from current index to the top
    private int solve(int index, int[] cost, int[] dp) {
        // Reached the top
        if (index >= cost.length)
            return 0;

        // Already calculated
        if (dp[index] != -1)
            return dp[index];

        dp[index] = cost[index] + Math.min(solve(index + 1, cost, dp), solve(index + 2, cost, dp));

        return dp[index];
    }
}
