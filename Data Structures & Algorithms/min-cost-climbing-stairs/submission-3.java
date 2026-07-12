class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Base cases
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        // Reach the top from last or second last stair
        return Math.min(prev1, prev2);
    }
}
