// Last updated: 5/26/2026, 12:33:43 PM
class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> dp=new HashMap<>();
        return climbStairs(n,dp);
    }
    private int climbStairs(int n,HashMap<Integer,Integer> dp){
        if(n<=1) return 1;
        if(!dp.containsKey(n)){
            dp.put(n,climbStairs(n-1,dp)+climbStairs(n-2,dp));
        }
        return dp.get(n);
    }
}