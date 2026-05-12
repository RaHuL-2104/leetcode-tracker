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
    private int solve(TreeNode root, int[] res){
        if(root == null) return 0;
        int l = solve(root.left, res);
        int r = solve(root.right, res);

        int height = Math.max(l, r) + 1;
        res[0] = Math.max(res[0], 1 + l + r);

        return height;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root, res);
        return res[0] - 1;
    }
}