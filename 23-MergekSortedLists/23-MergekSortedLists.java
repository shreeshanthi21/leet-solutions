// Last updated: 6/22/2026, 10:10:01 PM
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
12    public ListNode mergeKLists(ListNode[] lists) {
13        if (lists == null || lists.length == 0) {
14            return null;
15        }
16        return mergeKListsHelper(lists, 0, lists.length - 1);
17    }
18    
19    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
20        if (start == end) {
21            return lists[start];
22        }
23        if (start + 1 == end) {
24            return merge(lists[start], lists[end]);
25        }
26        int mid = start + (end - start) / 2;
27        ListNode left = mergeKListsHelper(lists, start, mid);
28        ListNode right = mergeKListsHelper(lists, mid + 1, end);
29        return merge(left, right);
30    }
31    
32    private ListNode merge(ListNode l1, ListNode l2) {
33        ListNode dummy = new ListNode(0);
34        ListNode curr = dummy;
35        
36        while (l1 != null && l2 != null) {
37            if (l1.val < l2.val) {
38                curr.next = l1;
39                l1 = l1.next;
40            } else {
41                curr.next = l2;
42                l2 = l2.next;
43            }
44            curr = curr.next;
45        }
46        
47        curr.next = (l1 != null) ? l1 : l2;
48        
49        return dummy.next;
50    }
51}
52