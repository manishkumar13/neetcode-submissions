class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int answer = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Reset after zero
            if (prefix == 0)
                prefix = 1;

            if (suffix == 0)
                suffix = 1;

            // Left to right product
            prefix *= nums[i];

            // Right to left product
            suffix *= nums[n - 1 - i];

            // Update answer
            answer = Math.max(answer, Math.max(prefix, suffix));
        }

        return answer;
    }
}
