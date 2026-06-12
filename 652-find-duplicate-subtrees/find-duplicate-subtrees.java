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

 // preorder traversing the tree 
 // storing the tree val in hashmap
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        dfs(root, mp, res);
        return res;
    }
    private String dfs(TreeNode root, HashMap<String, Integer> mp, List<TreeNode> res){
        if(root == null) return "N";
        String s = String.valueOf(root.val) + "," + dfs(root.left,mp,res) + "," +  dfs(root.right, mp, res);
        if(mp.containsKey(s) && mp.get(s) == 1){
            res.add(root);
        }
        mp.put(s, mp.getOrDefault(s, 0) + 1);
        return s;
    }
}