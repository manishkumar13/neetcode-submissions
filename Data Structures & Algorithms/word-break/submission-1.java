class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // -1 = not computed
        // 0 = false
        // 1 = true
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, set, dp);
    }

    private boolean solve(int index, String s, HashSet<String> set, int[] dp) {
        if (index == s.length())
            return true;

        if (dp[index] != -1)
            return dp[index] == 1;

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);

            if (set.contains(word)) {
                if (solve(end, s, set, dp)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        dp[index] = 0;
        return false;
    }
}
