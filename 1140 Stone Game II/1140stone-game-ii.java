class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum[i] = piles[i] + suffixSum[i+1];
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = n - 1; i >= 0; i--){
            for(int M = 1; M <= n; M++){
                for(int X = 1; X <= 2*M; X++){
                    if(i + X > n) break;
                    dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(M,X)]);
                }
            }
        }
        return dp[0][1];
    }
}

/** Top-down + Suffix sum

    private int[][] dp;
    private int[] suffixSum;

    public int stoneGameII(int[] piles){
        int n = piles.length;
        dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        suffixSum = new int[n];
        suffixSum[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i --){
            suffixSum[i] = piles[i] + suffixSum[i+1];
        }
        return dfs(0,1);
    }
    private int dfs(int i, int M){
        if(i == suffixSum.length) return 0;
        if(dp[i][M] != -1) return dp[i][M];

        int res = 0;
        for(int X = 1; X <= 2*M; X++){
            if(i + X > suffixSum.length) break;
            res = Math.max(res, suffixSum[i] - dfs(i+X, Math.max(M<X)));
        }
        return dp[i][M] = res;
    }
 */