class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minVal = prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minVal;
            if (profit > ans) {
                ans = profit;
            }
            if (prices[i] < minVal) {
                minVal = prices[i];
            }
        }
        return ans;
    }
}
