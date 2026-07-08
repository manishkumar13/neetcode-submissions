class Solution {
    // Returns the length of LCS considering
    // text1[0...index1] and text2[0...index2]
    private int helper(String text1, int index1, String text2, int index2, int[][] dp) {
        // Base case:
        // If either string is exhausted, LCS length is 0
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        // If this state has already been computed,
        // return the cached result
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // If the current characters match,
        // include this character in the LCS
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + helper(text1, index1 - 1, text2, index2 - 1, dp);
        }

        // Otherwise, try both possibilities:
        // 1. Skip current character of text1
        // 2. Skip current character of text2
        dp[index1][index2] = Math.max(helper(text1, index1 - 1, text2, index2, dp),
            helper(text1, index1, text2, index2 - 1, dp));

        return dp[index1][index2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        // dp[i][j] stores the LCS length for
        // text1[0...i] and text2[0...j]
        int[][] dp = new int[length1][length2];

        // Initialize all cells with -1
        for (int i = 0; i < length1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(text1, length1 - 1, text2, length2 - 1, dp);
    }
}
