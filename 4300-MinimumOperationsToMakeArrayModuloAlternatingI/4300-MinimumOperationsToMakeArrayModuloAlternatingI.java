// Last updated: 5/26/2026, 12:30:02 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        int[] l1=nums.clone();
        int[] eC=new int[k];
        int[] oC=new int[k];
        for(int i=0;i<nums.length;i++){
            int remainder=nums[i]%k;
            for(int j=0;j<k;j++){
                int difference=Math.abs(remainder-j);
                int cost=Math.min(difference,k-difference);
                if(i%2==0) eC[j]+=cost;
                else oC[j]+=cost;
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                if(i!=j){
                    result=Math.min(result,eC[i]+oC[j]);
                }
            }
        }
        return result;
    }
}