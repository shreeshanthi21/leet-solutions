// Last updated: 5/26/2026, 12:32:45 PM
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // Found it, return immediately!
            }
        }
        
        return -1;
    }
}