// Last updated: 5/26/2026, 12:33:50 PM
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode temp=head;
        int n=1;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;
        temp.next=head;
        for(int i=0;i<n-k;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}