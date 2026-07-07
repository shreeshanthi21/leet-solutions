// Last updated: 7/7/2026, 11:45:32 AM
1class Solution {
2    List<List<Integer>> res=new ArrayList<>();
3    void solve(int[] nums,List<Integer> op){
4        if(nums.length==0){
5            res.add(new ArrayList<>(op));
6            return;
7        }
8        List<Integer> op1=new ArrayList<>(op);
9        List<Integer> op2=new ArrayList<>(op);
10        op2.add(nums[0]);
11        nums = Arrays.copyOfRange(nums, 1, nums.length);
12        solve(nums,op1);
13        solve(nums,op2);
14    }
15    public List<List<Integer>> subsets(int[] nums) {
16        List<Integer> op=new ArrayList<>();
17        solve(nums,op);
18        return res;
19    }
20}