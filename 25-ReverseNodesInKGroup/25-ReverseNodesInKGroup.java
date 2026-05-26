// Last updated: 5/26/2026, 12:34:29 PM
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
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if (head == null || k == 1 || count < k) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        int tempo=k;
        ListNode current = head;
        for(int i=0;i<count/tempo;i++){
            ListNode prev = null;
            ListNode currentGroupHead = current;        
            int count2 = 0;
            while (current != null && count2 < tempo) {
                ListNode nextNode = current.next;
                current.next = prev;  
                prev = current;        
                current = nextNode;
                count2++;
            }
            prevGroupTail.next = prev;
            currentGroupHead.next = current;
            prevGroupTail = currentGroupHead;
        }
        
        return dummy.next;
    }
}