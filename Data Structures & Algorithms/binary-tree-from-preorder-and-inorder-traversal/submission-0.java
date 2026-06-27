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
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int instart,
        int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || instart > inEnd) {
            return null;
        }
        TreeNode currNode = new TreeNode(preorder[preStart]);
        int index = map.get(currNode.val);
        int numLeft = index - instart;
        currNode.left =
            helper(preorder, preStart + 1, preStart + numLeft, inorder, instart, index - 1, map);
        currNode.right =
            helper(preorder, preStart + numLeft + 1, preEnd, inorder, index + 1, inEnd, map);
        return currNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }
}
