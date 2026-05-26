// Last updated: 5/26/2026, 12:32:07 PM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int i1=hm.get(nums[i]);
                int i2=i;
                if(Math.abs(i1-i2)<=k) return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}