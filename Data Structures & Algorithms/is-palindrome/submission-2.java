class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char c = s.charAt(i);
            char d = s.charAt(j);
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
