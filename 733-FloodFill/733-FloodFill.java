// Last updated: 5/26/2026, 12:31:27 PM
class Solution {
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        int initialColor=image[sr][sc];
        if(initialColor!=color){
            dfs(image,sr,sc,initialColor,color);
        }
        return image;
    }
    public void dfs(int[][] image,int i,int j,int initialColor,int color){
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=initialColor) return;
        image[i][j]=color;
        int[] nrows={-1,0,+1,0};
        int[] ncols={0,+1,0,-1};
        for(int k=0;k<4;k++){
            int r=i+nrows[k];
            int c=j+ncols[k];
            dfs(image,r,c,initialColor,color);
        }
    }
}