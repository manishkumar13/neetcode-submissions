class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];

        return helper(0, nums, dp);
    }

    // Returns maximum money starting from current index
    private int helper(int index, int[] nums, Integer[] dp) {
        // No houses left
        if (index >= nums.length) {
            return 0;
        }

        // If already computed, return cached value
        if (dp[index] != null) {
            return dp[index];
        }

        // Rob current house
        int robCurrent = nums[index] + helper(index + 2, nums, dp);

        // Skip current house
        int skipCurrent = helper(index + 1, nums, dp);

        // Store answer before returning
        dp[index] = Math.max(robCurrent, skipCurrent);

        return dp[index];
    }
}
