class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int i = 0, j = n - 1;
        while (i <= j) {
            char c = s.charAt(i);
            char d = s.charAt(j);
            Character.isLetterOrDigit(c);
            if (!Character.isLetterOrDigit(c)) {
                i++;
            } else if (!Character.isLetterOrDigit(d)) {
                j--;
            } else if (c == d) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
