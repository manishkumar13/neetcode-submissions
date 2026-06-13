class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            s.add(i);
        }
        int ans = 1;
        for (Integer i : s) {
            int element = i;
            if (!s.contains(element - 1)) {
                int length = 1;
                while (s.contains(element + 1)) {
                    length++;
                    element++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
