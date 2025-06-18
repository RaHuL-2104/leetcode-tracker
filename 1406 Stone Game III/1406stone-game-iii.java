class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;

        for(int i= n-1; i >= 0; i--){
            int total = 0;
            dp[i] = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(i+3, n); j++){
                total += stoneValue[j];
                dp[i] = Math.max(dp[i], total - dp[j+1]);
            }
        }
        int result = dp[0];
        if(result == 0) return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }
}

/**
    Top-Down Approach-1 

    private int dp[];
    private int n;

    public String stoneGameIII(int[] stoneValue){
        this.n = stoneValue.length;
        this.dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int result = dfs(0, stoneValue);
        if(result == 0) return "Tie";
        return result > 0 ? "Alice": "Bob";
    }
    private int dfs(int i, int[] stoneValue){
        if(i >= n) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int res = Integer.MIN_VALUE, total = 0;
        for(int j = i; j < Math.min(i+3, n); j++){
            total += stoneValue[j];
            res = Math.max(res, total - dfs(j+1, stoneValue));
        }
        dp[i] = res;
        return res;
    }

    Top-Down Approach-2 (instead of returning stoneValue, we return the name of the players, MinMax Algo)

    private Integer[][] dp;
    private int n;

    public String stoneGameIII(int[] stoneValue){
        n = stoneValue.length;
        dp = new Integer[n][2];

        int result = dfs(0,1,stoneValue);
        if(result == 0) return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

    private int dfs(int i, int alice, int[] stoneValue){
        if(i >= n) return 0;
        if(dp[i][alice] != null) return dp[i][alice];

        int res = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score = 0;
        for(int j = i; j < Math.min(i+3, n); j++){
            if(alice == 1){
                score += stoneValue[j];
                res = Math.max(res, score + dfs(j+1,0,stoneValue));
            }else{
                score -= stoneValue[j];
                res = Math.min(res, score + dfs(j+1,1, stoneValue));
            }
        }
        dp[i][alice] = res;
        return res;
    } 
 */