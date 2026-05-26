// Last updated: 5/26/2026, 12:32:54 PM
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        int longestStreak=0;
        for(int i:hs){
            if(!hs.contains(i-1)){
                int currentNum=i;
                int currentStreak=1;
                while(hs.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                } 
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}