class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort to enable pruning
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int target, int[] candidates, List<Integer> current,
        List<List<Integer>> result) {
        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more candidates left
        if (index == candidates.length) {
            return;
        }

        // Pruning:
        // Since array is sorted, no need to continue if current candidate
        // is already greater than remaining target.
        if (candidates[index] > target) {
            return;
        }

        // -------------------------
        // Choice 1: Include current element
        // We stay at the same index because an element
        // can be picked unlimited times.
        // -------------------------
        current.add(candidates[index]);

        backtrack(index, target - candidates[index], candidates, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // -------------------------
        // Choice 2: Skip current element
        // Move to the next candidate.
        // -------------------------
        backtrack(index + 1, target, candidates, current, result);
    }
}