// Last updated: 5/26/2026, 12:30:16 PM
class Solution {
    public int passwordStrength(String password) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int strength=0;
        for(Character i:password.toCharArray()){
            if(hm.containsKey(i)) continue;
            hm.put(i,1);
            if(i>='a' && i<='z') strength+=1;
            if(i>='A' && i<='Z') strength+=2;
            if(i>='0' && i<='9') strength+=3;
            if("!@#$".indexOf(i)!=-1) strength+=5;
        }
        return strength;
    }
}