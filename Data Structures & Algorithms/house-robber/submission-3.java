class Solution {
    public int rob(int[] nums) {
        // Represents dp[i+1]
        int next = 0;

        // Represents dp[i+2]
        int nextNext = 0;

        // Traverse from last house to first
        for (int i = nums.length - 1; i >= 0; i--) {
            // Rob current house
            int robCurrent = nums[i] + nextNext;

            // Skip current house
            int skipCurrent = next;

            // Current answer
            int current = Math.max(robCurrent, skipCurrent);

            // Shift values for the next iteration
            nextNext = next;
            next = current;
        }

        return next;
    }
}
