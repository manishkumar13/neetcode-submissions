class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        // dp[i][j] stores the LCS length of
        // text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[length1 + 1][length2 + 1];

        // First row and first column are already 0

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // If current characters match,
                // include them in the LCS
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // Otherwise, skip one character from either string
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS of the complete strings
        return dp[length1][length2];
    }
}
