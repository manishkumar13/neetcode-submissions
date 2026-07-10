class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount + 1;

        int[][] dp = new int[n + 1][amount + 1];

        // Initialize last row (no coins left)
        for (int j = 1; j <= amount; j++) {
            dp[n][j] = INF;
        }

        // Fill table from bottom to top
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = 0;

            for (int j = 1; j <= amount; j++) {
                // Skip current coin
                int skip = dp[i + 1][j];

                // Take current coin
                int take = INF;

                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[0][amount] == INF ? -1 : dp[0][amount];
    }
}
