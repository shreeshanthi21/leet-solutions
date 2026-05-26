// Last updated: 5/26/2026, 12:31:42 PM
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr=0,count=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr++;count+=curr;
            }
            else{
                curr=0;
            }
        }
        return count;
    }
}