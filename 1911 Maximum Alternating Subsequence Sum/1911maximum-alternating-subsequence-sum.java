// Top Down Approach

class Solution {
    int n;
    long[][] dp;
    public long solve(int idx, int[] nums, boolean isEven){
        if(idx >= n) return 0;
        if(dp[idx][isEven ? 1:0] != -1) return dp[idx][isEven ? 1 : 0];
        long skip = solve(idx+1,nums,isEven);

        long val = isEven ? nums[idx] : -nums[idx];
        long take = solve(idx + 1,nums,!isEven) + val;

        return dp[idx][isEven ? 1 : 0] = Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(0,nums,true);
    }

    /* Bottom Up Approach (1-based indexing) 
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(int i = 1; i <= n; i++){
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1],dp[i-1][1]);
        }
        return Math.max(dp[n][0],dp[n][1]);
    */
}