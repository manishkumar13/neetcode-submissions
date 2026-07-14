class Solution {
    public int maxProduct(int[] nums) {
        // Maximum product ending at current index
        int maxEnding = nums[0];

        // Minimum product ending at current index
        int minEnding = nums[0];

        // Overall maximum product
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Negative number swaps max and min
            if (current < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            // Either start new subarray or extend previous one
            maxEnding = Math.max(current, maxEnding * current);
            minEnding = Math.min(current, minEnding * current);

            // Update answer
            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }
}
