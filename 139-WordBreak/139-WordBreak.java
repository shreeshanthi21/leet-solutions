// Last updated: 5/26/2026, 12:32:41 PM
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>(wordDict);
        int maxLen=0;
        for(String word:wordSet){
            maxLen=Math.max(maxLen,word.length());
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        //Base case: no words in s->return ""
        dp[0]=true;
        //Checking substrings
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}