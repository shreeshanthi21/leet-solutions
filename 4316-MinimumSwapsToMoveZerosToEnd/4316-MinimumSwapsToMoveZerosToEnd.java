// Last updated: 5/26/2026, 12:30:08 PM
class Solution {
    public int minimumSwaps(int[] nums) {
        int right=nums.length-1;
        int i=0;
        int count=0;
        while(i<=right){
            if(nums[i]==0){
                while(right>i && nums[right]==0) right--;
                if(i<right){
                    nums[right]=nums[i];
                    nums[i]=0;
                    right--;
                    count++;
                }
            }
            i++;
        }
        return count;
    }
}