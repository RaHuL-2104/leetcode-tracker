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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodeStack;
        TreeNode* current = root;
        while(current != NULL || !nodeStack.empty()){
            while(current != NULL){
                nodeStack.push(current);
                current = current -> left;
            }
            current = nodeStack.top();
            nodeStack.pop();
            result.push_back(current->val);
            current = current->right;
        }
        return result;
    }
};