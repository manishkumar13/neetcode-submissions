class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.isEmpty() && map.get(nums[i]) != null && map.get(nums[i])) {
                return true;
            }
            map.put(nums[i], true);
        }
        return false;
    }
}