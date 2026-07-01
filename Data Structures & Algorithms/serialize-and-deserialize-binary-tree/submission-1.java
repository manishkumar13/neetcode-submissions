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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                sb.append("N,");
                continue;
            }

            sb.append(curr.val).append(",");

            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // Left child
            if (!nodes[index].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curr.left);
            }
            index++;

            // Right child
            if (!nodes[index].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curr.right);
            }
            index++;
        }

        return root;
    }
}
