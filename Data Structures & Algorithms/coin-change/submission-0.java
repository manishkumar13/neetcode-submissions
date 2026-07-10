class Solution {
    // Returns minimum coins needed from index onward
    private int solve(int index, int[] coins, int amount) {
        // Amount formed successfully
        if (amount == 0) {
            return 0;
        }

        // No coins left
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;

        // Take current coin (unlimited supply)
        if (coins[index] <= amount) {
            int result = solve(index, coins, amount - coins[index]);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        // Skip current coin
        int skip = solve(index + 1, coins, amount);

        return Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int ans = solve(0, coins, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
