// Last updated: 6/8/2026, 9:44:54 PM
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int[] nextGreater = new int[10001];
4        Stack<Integer> stack = new Stack<>();
5
6        for (int i = nums2.length - 1; i >= 0; i--) {
7            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
8                stack.pop();
9            }
10            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
11            stack.push(nums2[i]);
12        }
13
14        for (int i = 0; i < nums1.length; i++) {
15            nums1[i] = nextGreater[nums1[i]];
16        }
17
18        return nums1;
19    }
20}