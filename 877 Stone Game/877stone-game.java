class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];

        for(int l = n-1; l >= 0; l--){
            for(int r = l; r < n; r++){
                boolean even = (r-1) % 2 == 0;
                int left = even ? piles[l] : 0;
                int right = even ? piles[r] : 0;

                if(l == r){
                    dp[r] = left;
                }else{
                    dp[r] = Math.max(dp[r] + left, dp[r-1] + right);
                }
            }
        }
        int total = 0;
        for(int pile : piles){
            total += pile;
        }
        int aliceScore = dp[n - 1];
        return aliceScore > (total - aliceScore);
    }
}

/** Top Down Approach
    private[][] dp;
    public boolean stoneGame(int[] piles){
        int n = piles.length;
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        int total = 0;
        for(int pile : piles){
            total += pile;
        }
        int aliceScore = dfs(0, n-1, piles);
        return aliceScore > total - aliceScore;
    }
    private int dfs(int l, int r, int[] piles){
        if(l > r) return 0;
        if(dp[l][r] != -1){
            return dp[l][r];
        }
        boolean even = (r - l)% 2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        dp[l][r] = Math.max(dfs(l+r, r, piles) + left, dfs(l, r-1, piles) + right);
        return dp[l][r];
    }

 */