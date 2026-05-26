// Last updated: 5/26/2026, 12:33:33 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int c=0;
        for (int i=0;i<nums.length;i++){
            if(c==0||c==1||nums[c-2]!=nums[i]){
                nums[c]=nums[i];
                c++;
            }
        }
        return c;
    }
}