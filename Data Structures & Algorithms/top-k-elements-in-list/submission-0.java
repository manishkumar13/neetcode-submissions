class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int arr[] = new int[2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            minHeap.add(new int[] {m.getValue(), m.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll()[1];
        }
        return ans;
    }
}
