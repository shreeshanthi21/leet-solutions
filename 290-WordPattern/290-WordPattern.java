// Last updated: 5/26/2026, 12:31:50 PM
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(words.length!=pattern.length()) return false;
        Map index=new HashMap();
        for(int i=0;i<words.length;++i){
            if(!Objects.equals(index.put(pattern.charAt(i),i), index.put(words[i],i))){
                return false;
            }
        }
        return true;
    }
}