class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length,s1=0,s2=0;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            s1+=grid[0][i];
            dp[0][i]=s1;
        }
        for(int i=0;i<n;i++){
            s2+=grid[i][0];
            dp[i][0]=s2;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}