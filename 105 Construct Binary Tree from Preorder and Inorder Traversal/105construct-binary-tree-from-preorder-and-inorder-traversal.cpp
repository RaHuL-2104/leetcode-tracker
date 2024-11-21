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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> inMap;
        for (int i = 0; i < inorder.size(); i++) {
            inMap[inorder[i]] = i;
        }
        // Build the tree using a helper function
        return buildTreeHelper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);
    }

private:
    TreeNode* buildTreeHelper(vector<int>& preorder, int preStart, int preEnd,
                              vector<int>& inorder, int inStart, int inEnd,
                              unordered_map<int, int>& inMap) {
        // Base case: if the range is invalid
        if (preStart > preEnd || inStart > inEnd) {
            return nullptr;
        }

        // Root is the first element in preorder within the current range
        TreeNode* root = new TreeNode(preorder[preStart]);

        // Find the root's index in inorder
        int inRoot = inMap[root->val];
        // Number of nodes in the left subtree
        int numsLeft = inRoot - inStart;

        // Recursively build the left and right subtrees
        root->left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft,
                                     inorder, inStart, inRoot - 1, inMap);
        root->right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd,
                                      inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
};
