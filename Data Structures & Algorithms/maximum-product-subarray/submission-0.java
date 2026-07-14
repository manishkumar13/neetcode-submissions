class Solution {
    public int maxProduct(int[] nums) {
        return solve(nums, 1, nums[0], nums[0], nums[0]);
    }

    /**
     * index      -> Current index
     * maxEnding  -> Maximum product ending at previous index
     * minEnding  -> Minimum product ending at previous index
     * answer     -> Maximum product found so far
     */
    private int solve(int[] nums, int index, int maxEnding, int minEnding, int answer) {
        // Base Case
        if (index == nums.length) {
            return answer;
        }

        int current = nums[index];

        // If current number is negative, swap max and min
        if (current < 0) {
            int temp = maxEnding;
            maxEnding = minEnding;
            minEnding = temp;
        }

        // Either start new subarray or extend previous
        maxEnding = Math.max(current, maxEnding * current);
        minEnding = Math.min(current, minEnding * current);

        answer = Math.max(answer, maxEnding);

        return solve(nums, index + 1, maxEnding, minEnding, answer);
    }
}
