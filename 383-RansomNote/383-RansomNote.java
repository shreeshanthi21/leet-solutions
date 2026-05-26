// Last updated: 5/26/2026, 12:31:45 PM
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for (char c : magazine.toCharArray()) {
    hm.put(c, hm.getOrDefault(c, 0) + 1);
}
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(char c:ransomNote.toCharArray()){
            hm2.put(c,hm2.getOrDefault(c,0)+1);
        }
        for (char key : hm2.keySet()){
            if(!hm.containsKey(key)) return false;
            if(hm2.get(key)>hm.get(key)) return false;
        } 
        return true;
    }
}