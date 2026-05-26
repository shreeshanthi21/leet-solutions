// Last updated: 5/26/2026, 12:30:10 PM
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i)>k) continue;
            result.add(i);
        }
        int[] res=result.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}