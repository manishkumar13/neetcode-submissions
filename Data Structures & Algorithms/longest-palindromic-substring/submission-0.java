class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        // dp[i][j] = true if substring s[i...j] is palindrome
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        // Every single character is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of increasing length
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;

                // First and last character must match
                if (s.charAt(i) == s.charAt(j)) {
                    // Length 2 or 3
                    if (length <= 3) {
                        dp[i][j] = true;
                    }
                    // Check inside substring
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }

                    // Update answer
                    if (dp[i][j] && length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
