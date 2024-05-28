/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> encountered;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        encountered = new HashMap<>();
        return traverse(node);
    }
    private Node traverse(Node root){
        if(encountered.containsKey(root.val))
            return encountered.get(root.val);
        Node newNode = new Node(root.val);
        encountered.put(newNode.val,newNode);
        for (Node node : root.neighbors)
            newNode.neighbors.add(traverse(node));
        return newNode;
    }
}
