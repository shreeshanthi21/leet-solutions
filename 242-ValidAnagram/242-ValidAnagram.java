// Last updated: 5/26/2026, 12:31:56 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(char i:s.toCharArray()){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(char i:t.toCharArray()){
            hm2.put(i,hm2.getOrDefault(i,0)+1);
        }
        if(hm.equals(hm2)) return true;
        return false;
    }
}