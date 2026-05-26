// Last updated: 5/26/2026, 12:30:19 PM
class Solution {
    public int maxScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int sum=grid[i][0]+grid[i][1];
            result=Math.max(result,sum);
            for(int j=2;j<n;j++){
                sum=Math.max(sum+grid[i][j],grid[i][j-1]+grid[i][j]);
                result=Math.max(result,sum);
            }
        }
        for(int j=0;j<n;j++){
            int sum=grid[0][j]+grid[1][j];
            result=Math.max(result,sum);
            for(int i=2;i<m;i++){
                sum=Math.max(sum+grid[i][j],grid[i-1][j]+grid[i][j]);
                result=Math.max(result,sum);
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                result=Math.max(result,grid[i][j]);
            }
        }
        return result;
    }
}