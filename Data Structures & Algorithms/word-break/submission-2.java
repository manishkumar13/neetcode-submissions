class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();

        // dp[i] = true if first i characters can be segmented
        boolean[] dp = new boolean[n + 1];

        // Empty string is always valid
        dp[0] = true;

        // Check every prefix ending at position i
        for (int i = 1; i <= n; i++) {
            // Try every possible split point
            for (int j = 0; j < i; j++) {
                // If prefix is valid and current word exists
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
