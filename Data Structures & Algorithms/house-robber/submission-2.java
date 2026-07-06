class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Extra two spaces avoid boundary checks for i+1 and i+2
        int[] dp = new int[n + 2];

        // Fill DP table from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Rob current house and skip next
            int robCurrent = nums[i] + dp[i + 2];

            // Skip current house
            int skipCurrent = dp[i + 1];

            // Store the better choice
            dp[i] = Math.max(robCurrent, skipCurrent);
        }

        // Maximum money starting from first house
        return dp[0];
    }
}
