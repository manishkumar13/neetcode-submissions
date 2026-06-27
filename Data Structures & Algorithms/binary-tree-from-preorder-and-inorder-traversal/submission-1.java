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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder value -> index for O(1) lookup
        Map<Integer, Integer> inorderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderIndex);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight,
        Map<Integer, Integer> inorderIndex) {
        // No nodes left
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // First element in preorder is always the root
        TreeNode root = new TreeNode(preorder[preLeft]);

        // Find root position in inorder
        int rootIndex = inorderIndex.get(root.val);

        // Number of nodes in left subtree
        int leftSize = rootIndex - inLeft;

        // Build left subtree
        root.left =
            build(preorder, preLeft + 1, preLeft + leftSize, inLeft, rootIndex - 1, inorderIndex);

        // Build right subtree
        root.right =
            build(preorder, preLeft + leftSize + 1, preRight, rootIndex + 1, inRight, inorderIndex);

        return root;
    }
}
