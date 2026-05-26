// Last updated: 5/26/2026, 12:34:28 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[c-1]){
                nums[c]=nums[i];
                c++;
            }
        }
        return c;
    }
}