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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode gPrev = dummy;

        while(true){
            ListNode node = getKthNode(gPrev,k);
            if(node == null) break;
            ListNode gNext = node.next;
            ListNode prev = node.next;
            ListNode curr = gPrev.next;

            while(curr!=gNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = gPrev.next;
            gPrev.next = node;
            gPrev = temp;
        }
        return dummy.next;
    }

    ListNode getKthNode(ListNode head, int k){
        while(head!=null && k>0){
            head = head.next;
            k--;
        }
        return head;
    }
}
