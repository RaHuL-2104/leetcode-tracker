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
    // private Map<Integer, Integer> mp = new HashMap<>();

    // public void inorder(TreeNode node){
    //     if(node == null) return;
    //     inorder(node.left);
    //     mp.put(node.val, mp.getOrDefault(node.val, 0) + 1);
    //     inorder(node.right);
    // }
    // public int[] findMode(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     inorder(root);
    //     int maxFreq = 0;

    //     for(Map.Entry<Integer, Integer> e : mp.entrySet()){
    //         int key = e.getKey();
    //         int val = e.getValue();

    //         if(val > maxFreq){
    //             maxFreq = val;
    //             res.clear();
    //             res.add(key);
    //         } else if(val == maxFreq){
    //             res.add(key);
    //         }
    //     }


    //     int[] result = new int[res.size()];
    //     for(int i = 0; i < result.length; i++){
    //         result[i] = res.get(i);
    //     }
    //     return result;
    // }

    /** WITHOUT EXTRA SPACE */
    private int currNum = 0;
    private int currStreak = 0;
    private int maxStreak = 0;
    private List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        if(node.val == currNum){
            currStreak++;
        } else{
            currNum = node.val;
            currStreak = 1;
        }

        if(currStreak > maxStreak){
            res.clear();
            maxStreak = currStreak;
        }

        if(currStreak == maxStreak){
            res.add(node.val);
        }
        dfs(node.right);
    }

    public int[] findMode(TreeNode root){
        dfs(root);

        int[] resultArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resultArray[i] = res.get(i);
        }
        return resultArray;
    }
}