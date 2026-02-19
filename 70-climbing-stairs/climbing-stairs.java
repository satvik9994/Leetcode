class Solution {
    public int useFibo(int n,int[] dp){
        if(n == 2  || n == 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = useFibo(n - 1,dp) + useFibo(n - 2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0 ; i < n + 1;i++){
            dp[i] = -1;
        }
        return useFibo(n,dp);
    }
}