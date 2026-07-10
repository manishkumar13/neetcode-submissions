class Solution {
    private int solve(int index, int[] coins, int amount, int[][] dp) {
        // Amount formed
        if (amount == 0) {
            return 0;
        }

        // No coins left
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        // Already computed
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int take = Integer.MAX_VALUE;

        // Take current coin
        if (coins[index] <= amount) {
            int result = solve(index, coins, amount - coins[index], dp);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        // Skip current coin
        int skip = solve(index + 1, coins, amount, dp);

        return dp[index][amount] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(0, coins, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
