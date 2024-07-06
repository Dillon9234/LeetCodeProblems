/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node output = copyWithoutRandom(head,map);
        addRandoms(head,output,map);
        return output;
    }

    private Node copyWithoutRandom(Node head, HashMap<Node,Node> map){
        if(head == null)
            return null;
        Node newNode = new Node(head.val);
        map.put(head,newNode);
        newNode.next = copyWithoutRandom(head.next,map);
        return newNode;
    }
    private void addRandoms(Node original, Node copy,HashMap<Node,Node> map){
        if(original == null)
            return;
        if(original.random==null)
            copy.random = null;
        else
            copy.random = map.get(original.random);
        addRandoms(original.next,copy.next,map);
    }
}
