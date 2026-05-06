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
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = gPrev.next;
            gPrev.next = node;
            gPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k){
        while(curr!=null && k>0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
