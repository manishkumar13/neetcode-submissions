class Solution {
    public int climbStairs(int n) {
        // Base cases:
        // 1 stair -> 1 way
        // 2 stairs -> 2 ways
        if (n <= 2) {
            return n;
        }

        // prev2 represents ways to reach (i-2)th stair
        int prev2 = 1;

        // prev1 represents ways to reach (i-1)th stair
        int prev1 = 2;

        // Compute the number of ways from the 3rd stair up to the nth stair
        for (int i = 3; i <= n; i++) {
            // Ways to reach current stair
            // = ways from previous stair + ways from two stairs before
            int current = prev1 + prev2;

            // Update variables for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        // prev1 now contains the answer for the nth stair
        return prev1;
    }
}
