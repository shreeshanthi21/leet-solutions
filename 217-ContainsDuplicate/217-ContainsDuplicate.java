// Last updated: 6/4/2026, 10:23:50 PM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: nums)  {
            if(set.contains(num))   {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}