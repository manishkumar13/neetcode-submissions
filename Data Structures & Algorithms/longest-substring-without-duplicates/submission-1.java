class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        int l = 0, r = 0;
        int n = s.length();
        int ans = 0;
        while (l < n && r < n) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), true);
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                while (map.containsKey(s.charAt(r))) {
                    map.remove(s.charAt(l));
                    l++;
                }
            }
        }
        return ans;
    }
}
