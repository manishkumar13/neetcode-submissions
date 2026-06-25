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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalAns = new ArrayList<>();
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> ans = new ArrayList<>();
            while (n > 0) {
                TreeNode currTreeNode = queue.poll();
                ans.add(currTreeNode.val);
                if (currTreeNode.left != null) {
                    queue.add(currTreeNode.left);
                }
                if (currTreeNode.right != null) {
                    queue.add(currTreeNode.right);
                }
                n--;
            }
            finalAns.add(ans);
        }
        return finalAns;
    }
}
