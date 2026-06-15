class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int area = (j - i) * Integer.min(height[i], height[j]);
            maxArea = Integer.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
