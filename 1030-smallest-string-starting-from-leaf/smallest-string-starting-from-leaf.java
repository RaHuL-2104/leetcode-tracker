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
    String smallest = "~";
    public void dfs(TreeNode node, StringBuilder sb){
        if(node == null) return;
        sb.append((char) ('a' + node.val));
        if(node.left == null && node.right == null){
            String current = sb.reverse().toString();
            if(current.compareTo(smallest) < 0){
                smallest = current;
            }
            sb.reverse();
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
}