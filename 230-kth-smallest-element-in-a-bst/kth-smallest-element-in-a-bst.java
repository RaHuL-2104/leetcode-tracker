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

 // inorder traversal karke kuch hoga, smallest element toh nikal sakte hai by storing the prev element
 // add a counter to keep track, whenever we visit the node. If the counter equals to K -> that is your answer
class Solution {
    int kSmallest = Integer.MIN_VALUE;
    int count = 0;
    public void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left, k);
        count++;
        if(count == k) {
            kSmallest = root.val;
            return;
        }
        inorder(root.right, k);

    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return kSmallest;
    }
}