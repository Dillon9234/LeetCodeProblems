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
    int helper(TreeNode* root, int targetSum, long cur){
        int count = 0;
        cur += root->val;
        if(cur == targetSum){
            count++;
        }
        if(root->left){
            count += helper(root->left, targetSum, cur);
        }
        if(root->right){
            count += helper(root->right, targetSum, cur);
        }
        return count;
    }

    int help1(TreeNode* root, int targetSum) {
        int count = 0;
        if(root->val == targetSum)
            count++;
        if(root->left){
            count += helper(root->left,targetSum,root->val);
            count += help1(root->left,targetSum);
        }
        if(root->right){
            count += helper(root->right,targetSum,root->val);
            count += help1(root->right,targetSum);
        }
        return count;
    }

    int pathSum(TreeNode* root, int targetSum) {
        if(!root)
            return 0;
        int count = 0;
        count += help1(root,targetSum);
        return count;
    }
};
