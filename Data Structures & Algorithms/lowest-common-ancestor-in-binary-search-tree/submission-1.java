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
    public TreeNode lowestCommonAncestor(TreeNode curr, TreeNode p, TreeNode q) {
        while (curr != null) {
            // Both nodes are in the left subtree
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // Both nodes are in the right subtree
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // Current node is the split point (LCA)
            else {
                return curr;
            }
        }
        return null;
    }
}
