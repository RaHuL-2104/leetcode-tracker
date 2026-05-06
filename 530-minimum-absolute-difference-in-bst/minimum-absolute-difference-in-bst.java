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

 // DFS search store in arraylist and then find minDiff

 // 1 2 3 4 6
class Solution {
    public void dfs(TreeNode node, ArrayList<Integer> res){
        if(node == null) return;
        dfs(node.left,res);
        res.add(node.val);
        dfs(node.right,res);
    }
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, res);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < res.size(); i++){
            minDiff = Math.min(minDiff,Math.abs(res.get(i) - res.get(i-1)));
        }
        return minDiff;
    }
}