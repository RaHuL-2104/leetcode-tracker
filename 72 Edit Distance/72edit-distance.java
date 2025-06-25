class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(m < n){
            String temp = word1; word1 = word2; word2 = temp;
            m = word1.length(); n = word2.length();
        }
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++) dp[i] = n - i;

        for(int i = m - 1; i >= 0; i--){
            int nextDp = dp[n];
            dp[n] = m - i;
            for(int j = n - 1; j >= 0; j--){
                int temp = dp[j];
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[j] = nextDp;
                } else{
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j + 1],nextDp));
                }
                nextDp = temp;
            }
        }
        return dp[0];
    }
}

/**
    Top-Down Approach
    private int[]][] dp;
    public int minDistance(String word1, String word2){
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return dfs(0,0,word1,word2,m,n);
    }

    private int dfs(int i, int j, String word1, String word2, int m, int n){
        if(i == m) return n-j;
        if(j == n) return m-i;

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = dfs(i+1, j+1, word1, word2, m, n);
        } else{
            int res = Math.min(dfs(i+1, j, word1, word2, m, n), dfs(i, j+1, word1, word2, m, n));
            res = Math.min(res, dfs(i+1, j+1, word1, word2, m, n));
            dp[i][j] = res + 1;
        }
        return dp[i][j];
    }
 */