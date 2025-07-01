class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[p.length()] = true;

        for(int i = s.length(); i >= 0; i--){
            boolean dp1 = dp[p.length()];
            dp[p.length()] = (i == s.length());

            for(int j = p.length() - 1; j >= 0; j--){
                boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                boolean res = false;
                if(j+1 < p.length() && p.charAt(j + 1) == '*'){
                    res = dp[j+2];
                    if(match){
                        res |= dp[j];
                    }
                } else if (match){
                    res = dp1;
                }
                dp1 = dp[j];
                dp[j] = res;
            }
        }
        return dp[0];
    }
}

/* Top-Down Approach
    private Boolean[][] dp;

    public boolean isMatch(String s, String p){
        int m = s.length(), n = p.length();
        dp = new Boolean[m+1][n+1];
        return dfs(0, 0, s, p, m, n);
    }
    private boolean dfs(int i, int j, String s, String p, int m, int n){
        if(j == n){
            return i == m;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < n && p.charAt(j + 1) == '*'){
            dp[i][j] = dfs(i, j+2, s, p, m, n) || (match && dfs(i+1, j, s, p, m, n));
        }else{
            dp[i][j] = match && dfs(i+1, j+1, s, p, m, n);
        }
        return dp[i][j];
    }
 */