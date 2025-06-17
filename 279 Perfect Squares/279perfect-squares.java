class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;

        for(int target = 1; target <= n; target++){
            for(int s = 1; s*s <= target; s++){
                dp[target] = Math.min(dp[target], 1+dp[target - s*s]);
            }
        }
        return dp[n];
    }
}

/** Top-Down Approach
    Map<Integer,Integer> memo = new HashMap<>();
    private int dfs(int target){
        if(target == 0) return 0;
        if(memo.containsKey(return target)) return memo.get(target);

        int res = target;
        for(int i = 1; i*i <= target; i++){
            res = Math.min(res, 1+ dfs(target - i*i));
        }
        memo.put(target, res);
        return res;
    }
    public int numSquares(int n){
        return dfs(n);
    }
 */