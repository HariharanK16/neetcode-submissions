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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        for(int i = 1; i<lists.length;i++){
            lists[i] = merge2Lists(lists[i], lists[i-1]);
        }
        return lists[lists.length-1];
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur= cur.next;
        }
        if(l1!=null){
            cur.next = l1;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return res.next;
    }
}
