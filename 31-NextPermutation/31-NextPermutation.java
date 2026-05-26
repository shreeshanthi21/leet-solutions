// Last updated: 5/26/2026, 12:34:20 PM
class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;break;
            }
        }
        int temp;
        if(ind==-1) 
        {rev(nums,0,n-1);return;}
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
        }
        rev(nums,ind+1,n-1);
    }
    private static void rev(int[] arr,int left,int right){
            while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}