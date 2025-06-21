class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,1);

        for(int num: nums){
            Map<Integer, Integer> nextDp = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()){
                int total = entry.getKey();
                int count = entry.getValue();
                nextDp.put(total + num, nextDp.getOrDefault(total + num, 0)+ count);
                nextDp.put(total - num, nextDp.getOrDefault(total - num, 0)+ count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}

/**Top Down Approach
    private int[][] dp;
    private int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int num : nums) totalSum += num;
        dp = new int[nums.length][2*totalSum + 1];
        for(int i = 0; i <nums.length; i++){
            for(int j = 0; j < 2*totalSum + 1; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return backtrack(0,0,nums,target);
    }

    private int backtrack(int i, int total, int[] nums, int target){
        if(i == nums.length){
            return total == target ? 1:0;
        }
        if(dp[i][total + totalSum] != Integer.MIN_VALUE){
            return dp[i][total + totalSum];
        }
        dp[i][total + totalSum] = backtrack(i+1, total + nums[i], nums, target) + backtrack(i+1, total - nums[i], nums, target) ;
        return dp[i][total + totalSum];
    }
 */