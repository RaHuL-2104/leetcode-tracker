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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode* > nodeStack;
        nodeStack.push(root);
        while(!nodeStack.empty()){
            TreeNode* currentNode = nodeStack.top();
            nodeStack.pop();
            if(currentNode != NULL){
            result.push_back(currentNode-> val);
            if(currentNode->right) nodeStack.push(currentNode->right);
            if(currentNode->left) nodeStack.push(currentNode->left);
            }
        }
        return result;
    }
};