/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private void inOrderTraversal(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrderTraversal(root.left, list, k);
        }
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        if (root.right != null) {
            inOrderTraversal(root.right, list, k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list, k);
        return list.isEmpty() || list.size() < k ? -1 : list.get(k - 1);
    }
}
