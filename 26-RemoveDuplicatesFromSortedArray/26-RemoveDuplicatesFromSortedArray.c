// Last updated: 5/26/2026, 12:34:34 PM
int removeDuplicates(int* nums, int numsSize) {
 int c=1;
    for(int i=0;i<numsSize;i++){
        if(nums[i]!=nums[c-1]){
            nums[c]=nums[i];
            c++;
        }
    }
    return c;
}