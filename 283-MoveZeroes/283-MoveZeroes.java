// Last updated: 5/26/2026, 12:31:52 PM
class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
        }
    }
}