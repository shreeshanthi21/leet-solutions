// Last updated: 5/26/2026, 12:31:05 PM
class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> ns=new HashSet<>();
        int deletions=0;
        for(int freq:map.values()){
            while(freq>0 && ns.contains(freq)){
                freq--;deletions++;
            }
            if(freq>0) ns.add(freq);
        }
        return deletions;
    }
}