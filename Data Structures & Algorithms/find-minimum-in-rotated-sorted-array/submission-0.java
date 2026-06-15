class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[i] <= nums[mid]) {
                minVal = Math.min(minVal, nums[i]);
                i = mid + 1;
            } else {
                minVal = Math.min(minVal, nums[mid]);
                j = mid - 1;
            }
        }
        return minVal;
    }
}
