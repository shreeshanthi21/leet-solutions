// Last updated: 7/7/2026, 11:54:53 AM
1class Solution {
2    Set<List<Integer>> res=new HashSet<>();
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
15    public List<List<Integer>> subsetsWithDup(int[] nums) {
16        Arrays.sort(nums); 
17        List<Integer> op=new ArrayList<>();
18        solve(nums,op);
19        return new ArrayList<>(res);
20    }
21}