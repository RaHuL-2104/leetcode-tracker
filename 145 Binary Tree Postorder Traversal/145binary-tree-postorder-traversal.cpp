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
private:
    vector<int> result;
public:
    vector<int> postorderTraversal(TreeNode* root) {
       /* stack<TreeNode*> st;
        stack<bool> visit;
        vector<int> res;
        if(root != NULL){
            st.push(root);
            visit.push(false);
        }
        while (!st.empty()){
            TreeNode* current = st.top();
            st.pop();
            bool v = visit.top();
            visit.pop();
            if(current != NULL){
                if(v){
                    res.push_back(current -> val);
                }
                else{
                    st.push(current);
                    visit.push(true);
                    if(current->right){
                        st.push(current->right);
                        visit.push(false);
                    }
                    if(current->left){
                        st.push(current->left);
                        visit.push(false);
                    }
                }
            }
        }
        return res;
        */
          if(!root) return {}; 

        postorderTraversal(root->left);
        postorderTraversal(root->right);
        result.push_back(root->val);
        
        return result;
    }
};