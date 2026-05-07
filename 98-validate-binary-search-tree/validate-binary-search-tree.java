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

 // inorder traversal of this tree and check whether the tree is sorted or not
class Solution {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return res;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        int f = 0;
        for(int i = 1; i < res.size(); i++){
            if(res.get(i) <= res.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
// 1 5 3 4 6