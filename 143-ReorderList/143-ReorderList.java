// Last updated: 7/8/2026, 9:07:51 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public void reorderList(ListNode head) {
13        if (head == null) return;
14
15        // Step 1: Find the middle of the list
16        ListNode slow = head, fast = head;
17        while (fast != null && fast.next != null) {
18            slow = slow.next;
19            fast = fast.next.next;
20        }
21
22        // Step 2: Reverse the second half of the list
23        ListNode second = slow.next;
24        slow.next = null;
25        ListNode node = null;
26
27        while (second != null) {
28            ListNode temp = second.next;
29            second.next = node;
30            node = second;
31            second = temp;
32        }
33
34        // Step 3: Merge the two halves
35        ListNode first = head;
36        second = node;
37
38        while (second != null) {
39            ListNode temp1 = first.next, temp2 = second.next;
40            first.next = second;
41            second.next = temp1;
42            first = temp1;
43            second = temp2;
44        }        
45    }
46}