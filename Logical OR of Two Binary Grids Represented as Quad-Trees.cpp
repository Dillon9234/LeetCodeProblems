/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    Node* intersect(Node* quadTree1, Node* quadTree2) {
        Node* root = helper(quadTree1, quadTree2);
        return root;
    }

    Node* helper(Node* quadTree1, Node* quadTree2){
        if(quadTree1->isLeaf){
            if(quadTree1->val){
                return quadTree1;
            }else{
                return quadTree2;
            }
        }else{
            if(quadTree2->isLeaf){
                if(quadTree2->val){
                    return quadTree2;
                }else{
                    return quadTree1;
                }
            }else{
                Node* root = new Node(true,false);
                root->topLeft = helper(quadTree1->topLeft, quadTree2->topLeft);
                root->topRight = helper(quadTree1->topRight, quadTree2->topRight);
                root->bottomLeft = helper(quadTree1->bottomLeft, quadTree2->bottomLeft);
                root->bottomRight = helper(quadTree1->bottomRight, quadTree2->bottomRight);

                if(root->topLeft->isLeaf && root->topRight->isLeaf && root->bottomLeft->isLeaf && root->bottomRight->isLeaf
                    && root->topLeft->val == root->topRight->val 
                    && root->topLeft->val == root->bottomLeft->val 
                    && root->topLeft->val == root->bottomRight->val){
                        return new Node(root->topLeft->val,true);
                }
                return root;
            }
        }
    }
};
