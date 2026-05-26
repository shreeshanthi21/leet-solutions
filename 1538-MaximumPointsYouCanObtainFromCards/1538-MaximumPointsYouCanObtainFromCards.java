// Last updated: 5/26/2026, 12:31:15 PM
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        for(int i=1;i<=k;i++){
            sum-=cardPoints[k-i];
            sum+=cardPoints[n-i];
            max=Math.max(sum,max);
        }
        return max;
    }
}
