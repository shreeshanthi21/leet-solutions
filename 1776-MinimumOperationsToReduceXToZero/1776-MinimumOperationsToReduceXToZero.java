// Last updated: 5/26/2026, 12:31:03 PM
class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0;
        int maxlen=-1,sum=0;
        for(int num:nums) sum+=num;
        int currsum=0;
        for(int right=0;right<nums.length;right++){
            currsum+=nums[right];
            while(left<=right && currsum>sum-x) currsum-=nums[left++];
            if(currsum==sum-x) maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen == -1 ? -1 :nums.length-maxlen;
    }
}