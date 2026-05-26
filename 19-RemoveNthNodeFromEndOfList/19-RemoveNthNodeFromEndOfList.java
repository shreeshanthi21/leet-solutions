// Last updated: 5/26/2026, 12:34:38 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;temp=temp.next;
        }
        temp=head; ListNode prev=null;
        if(count==n) return head.next;
        int target=count-n;
        while(target!=0){
            prev=temp;
            temp=temp.next;
            target--;
        }
        prev.next=temp.next;
        return head;
    }
}