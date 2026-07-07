class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // If there is only one house, rob it
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude last house
        int option1 = robRange(nums, 0, n - 2);

        // Case 2: Exclude first house
        int option2 = robRange(nums, 1, n - 1);

        return Math.max(option1, option2);
    }

    // Returns maximum money that can be robbed
    // from index 'start' to 'end' (inclusive)
    private int robRange(int[] nums, int start, int end) {
        // dp[i+1]
        int next = 0;

        // dp[i+2]
        int nextNext = 0;

        // Traverse from right to left
        for (int i = end; i >= start; i--) {
            // Rob current house
            int robCurrent = nums[i] + nextNext;

            // Skip current house
            int skipCurrent = next;

            // Best choice at current house
            int current = Math.max(robCurrent, skipCurrent);

            // Shift values for next iteration
            nextNext = next;
            next = current;
        }

        return next;
    }
}
