class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];

        dp[n] = 1;
        for(int i = m-1; i >= 0; i--){
            int prev = 1;
            for(int j = n-1; j >= 0; j--){
                int res = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    res += prev;
                }
                prev = dp[j];
                dp[j] = res;
            }
        }
        return dp[0];
    }
}


/** Top Down Approach
    private int[][] dp;
    public int numDistinct(String s, String t){
        int m = s.length(), n = t.length();
        if(n > m) return 0;
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, t, 0, 0);
    }
    private int dfs(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int res = dfs(s,t,i+1,j);
        if(s.charAt(i) == t.charAt(j)){
            res += dfs(s,t,i+1,j+1);
        }
        dp[i][j] = res;
        return res;
    }
 */