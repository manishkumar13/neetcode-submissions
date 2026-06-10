class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                int j = map.get(val);
                if (i < j)
                    return new int[] {i, j};
                else
                    return new int[] {j, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
