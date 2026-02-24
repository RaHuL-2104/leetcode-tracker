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
    public int sumRootToLeaf(TreeNode root) {
        return preOrder(root, 0);
    }
    public int preOrder(TreeNode node, int current){
        if(node == null) return 0;
        current = current * 2 + node.val;
        if(node.left == node.right) return current;
        return preOrder(node.left, current) + preOrder(node.right, current);
    }
}