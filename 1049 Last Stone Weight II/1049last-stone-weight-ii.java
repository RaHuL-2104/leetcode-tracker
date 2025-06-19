class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for(int stone : stones){
            stoneSum += stone;
        }
        int target = stoneSum/2;
        int[] dp = new int[target+1];
        
        for(int stone : stones){
            for(int t = target; t >= stone; t--){
                dp[t] = Math.max(dp[t], dp[t-stone] + stone);
            }
        }
        return stoneSum - 2 * dp[target];
    }
}

/** Top-Down Approach
    private int dp[][];
    public int lastStoneWeightIII(int[] stones){
        int stoneSum = 0;
        for(int stone : stones){
            stoneSum += stone;
        }
        int target = (stoneSum + 1)/2;
        dp = new int[stones.length][target + 1];
        for(int i = 0; i < stones.length; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -1;
            }
        }
        return dfs(0,0, stones, stoneSum, target);
    }

    private int dfs(int i, int total, int[] stones, int stoneSum, int target){
        if(total >= target || i == stones.length){
            return Math.abs(total - (stoneSum - total));
        }
        if(dp[i][total] != -1){
            return dp[i][total];
        }

        dp[i][total] = Math.min(
            dfs(i+1, total, stones, stoneSum, target),
            dfs(i+1, total + stones[i], stone, stoneSum, target)
        );
        return dp[i][total];
    }
 */