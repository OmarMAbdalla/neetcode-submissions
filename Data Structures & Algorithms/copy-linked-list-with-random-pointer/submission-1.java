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
        HashMap<Node, Node> memo = new HashMap<>();
        Node head2 = head;

        while(head2 != null){
            Node cur = new Node (head2.val);
            memo.put(head2, cur);
            head2=head2.next;
        }
        head2 = head;

        while(head2 != null){
            Node curr = memo.get(head2);
            curr.next = memo.get(head2.next);
            curr.random = memo.get(head2.random);
            head2=head2.next;
        }

        return memo.get(head);
    }
}
