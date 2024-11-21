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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() != postorder.size()){
            return NULL;
        }
        unordered_map<int,int> inMap;
        for(int i = 0;i<inorder.size();i++){
            inMap[inorder[i]] = i;
        }
        return buildTreeHelper(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1,inMap);
    }
    TreeNode* buildTreeHelper(vector<int>& inorder,int inStart, int inEnd,vector<int>& postorder,int posStart, int posEnd,unordered_map<int,int>& inMap){
        if(posStart > posEnd || inStart > inEnd){
            return NULL;
        }
        TreeNode* root = new TreeNode(postorder[posEnd]);
        int inRoot = inMap[postorder[posEnd]];
        int LeftSubtreeSize = inRoot - inStart;
        root->left = buildTreeHelper(inorder,inStart,inRoot-1,postorder,posStart,posStart+LeftSubtreeSize-1,inMap);
        root->right = buildTreeHelper(inorder,inRoot+1,inEnd,postorder,posStart+LeftSubtreeSize,posEnd-1,inMap);
        return root;
    }
};