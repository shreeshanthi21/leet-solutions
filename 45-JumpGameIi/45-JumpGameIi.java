// Last updated: 5/26/2026, 12:34:06 PM
class Solution {
    public int jump(int[] nums) {
        int jumps=0,left=0,right=0;
        int n=nums.length;
        while(right<n-1){
            int farthest=0;
            for(int i=left;i<=right;i++){
                farthest=Math.max(i+nums[i],farthest);
            }
            left=right+1;
            right=farthest;
            jumps=jumps+1;
        }
        return jumps;
    }
}