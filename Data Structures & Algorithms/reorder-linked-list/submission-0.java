/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // create a reversed list. 
        // find count. 
        // initialize count, if even then take from head, if odd then take from reversed, if == count then return reordered. 
        ListNode curr = head;
        int actualCount = 0; 
        while (curr != null){
            curr = curr.next;
            actualCount++;
        }

        ListNode reversed = reverseCopy(head);
        ListNode headReordered = new ListNode();
        ListNode headReorderedPointer = headReordered;
        ListNode first = head;

        int count = 0;
        while(count < actualCount && headReordered != null && reversed != null){
            if(count % 2 == 0){
                headReordered.val = first.val;
                first = first.next;

            }else{
                 headReordered.val = reversed.val;  
                 reversed = reversed.next;             
            }
            count++;
            if(count < actualCount){
                headReordered.next = new ListNode();
                headReordered=headReordered.next;
            }

        }
        ListNode src = headReorderedPointer;
        for (ListNode c = head; c != null; c = c.next) {
            c.val = src.val;
            src = src.next;
        }

    }
    // Builds a reversed copy with new nodes; the original list is untouched.
    private ListNode reverseCopy(ListNode head) {
        ListNode prev = null;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            prev = new ListNode(curr.val, prev);   // push each value onto the front
        }
        return prev;
    }
}
