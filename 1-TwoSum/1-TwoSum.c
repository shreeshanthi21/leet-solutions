// Last updated: 5/26/2026, 12:35:08 PM
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int *result = (int *)malloc(2 * sizeof(int)); // Allocate for 2 ints
    *returnSize = 0;

    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;   
                result[1] = j;    
                *returnSize = 2;
                return result; 
            }
        }
    }
    return result; 
}