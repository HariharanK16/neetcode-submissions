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
        Node dummy =head;

        Map<Node,Node> oldToNew = new HashMap<>();
        oldToNew.put(null,null);

        Node curr = dummy;

        while(curr!=null){
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = dummy;

        while(curr!=null){
            Node newNode = oldToNew.get(curr);
            newNode.next = oldToNew.get(curr.next);
            newNode.random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(dummy);
    }
}
