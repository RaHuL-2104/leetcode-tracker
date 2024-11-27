/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void inorder(TreeNode* node, int &counter, int k,int& kSmall){
        if(!node || counter >=k) return;
        inorder(node->left,counter,k,kSmall);
        counter++;
        if(counter == k){
            kSmall= node->val;
            return;
        }
        inorder(node->right,counter,k,kSmall);
    }
    int kthSmallest(TreeNode* root, int k) {
        int kSmall = INT_MIN;
        int counter = 0;
        inorder(root,counter,k,kSmall);
        return kSmall;
    }
};