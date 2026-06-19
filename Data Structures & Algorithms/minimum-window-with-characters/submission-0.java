class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int l = 0, r = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        while (r < n) {
            char d = s.charAt(r);
            if (map.getOrDefault(d, 0) > 0) {
                count++;
            }
            map.merge(d, -1, Integer::sum);
            while (count == m) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                char c = s.charAt(l);
                map.merge(c, 1, Integer::sum);
                if (map.get(c) > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
