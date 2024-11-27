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
    bool isValidBST(TreeNode* root) {
        bool b = true;
        bool first = true;
        int prev;
        TreeNode* curr = root;
        while(curr){
            if(curr->left == NULL){
                if(first){
                    prev = curr->val;
                    first = false;
                }
                else{
                    if(curr->val <= prev){
                        b = false;
                    }
                    else{
                        prev = curr->val;
                    }
                }
                curr = curr->right;
            }
            else{
                TreeNode* temp = curr->left;
                while(temp->right && temp->right != curr){
                    temp = temp->right;
                }
                if(temp->right == NULL){
                    temp->right = curr;
                    curr = curr->left;
                }
                else{
                    if(curr->val <= prev){
                        b = false;
                    }
                    else{
                        prev = curr->val;
                    }
                    temp->right = NULL;
                    curr = curr->right;
                }
            }
        }
        if(b){
            return true;
        }
        return false;
    }
};