// Last updated: 5/26/2026, 12:32:11 PM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int mini=Integer.MAX_VALUE;
        int n=nums.length;
        int sum=0;
        int left=0;int right=0;
        while(right<n){
            sum += nums[right];
            while (sum >= target){
               mini=Math.min(mini,right-left+1);
               sum -= nums[left];
               left++;
            }
            right++;
        }
        if(mini==Integer.MAX_VALUE) return 0;
        return mini;
    }
}