class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int num = 2; num <= n; num++){
            dp[num] = (num == n)? 0 : num;
            for(int i = 1; i < num; i++){
                dp[num] = Math.max(dp[num], dp[i] * dp[num - i]);
            }
        }
        return dp[n];
    }
}

/** Top-Down Approach
    private Map<Integer,Integer> dp;
    public int integerBreak(int n){
        dp = new HashMap<>();
        dp.put(1,1);
        return dfs(n,n);
    }
    private int dfs(int num, int n){
        if(dp.containsKey(num)){
            return dp.get(num);
        }
        int res = (num == n) ? 0:num;
        for(int i = 1; i < num; i++){
            int val = dfs(i,n) * dfs(num - i, n);
            res = Math.max(res,val);
        }
        dp.put(num,res);
        return res;
    }
 */