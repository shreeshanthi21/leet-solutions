// Last updated: 5/26/2026, 12:32:25 PM
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }
            else{hm.put(i,1);}
        }
        return Collections.max(hm.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}