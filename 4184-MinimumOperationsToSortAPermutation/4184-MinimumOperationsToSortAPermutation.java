// Last updated: 5/26/2026, 12:30:06 PM
class Solution {
   public int minOperations(int[] nums) {
       int n=nums.length;
       int index=-1;
       int index1=-1;
       for(int i=0;i<n;i++){
           if(nums[i]==0) index=i;
           if(nums[i]==n-1) index1=i;
       }
       int minOp= Integer.MAX_VALUE;
       boolean circular=true;
       for(int i=0;i<n;i++){
           if(nums[(i+1)%n]!=(nums[i]+1)%n){
               circular=false;
               break;
           }
       }
       if(circular){
           minOp=Math.min(minOp,index);
           minOp=Math.min(minOp,2+(n-index)%n);
       }
       boolean rev=true;
       for(int i=0;i<n;i++){
           if(nums[(i+1)%n]!=(nums[i]-1+n)%n){
               rev=false;
               break;
           }
       }
       if(rev){
           minOp=Math.min(minOp,1+index1);
           minOp=Math.min(minOp,1+(n-1-index));
       }
       return minOp==Integer.MAX_VALUE?-1:minOp;
   }
}