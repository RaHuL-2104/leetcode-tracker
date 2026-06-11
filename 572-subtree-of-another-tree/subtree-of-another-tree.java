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
    private String preOrderTrav(TreeNode root){
        if(root == null) return "null";
        StringBuilder st = new StringBuilder("^");
        st.append(root.val);
        st.append(preOrderTrav(root.left));
        st.append(preOrderTrav(root.right));
        
        return st.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String main = preOrderTrav(root);
        String sub = preOrderTrav(subRoot);
        if(main.contains(sub)){
            return true;
        }
        return false;
    }
}