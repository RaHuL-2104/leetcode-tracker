class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftPrefix = new int[n];
        int[] rightSuffix = new int[n];
        leftPrefix[0] = 0;
        rightSuffix[n - 1] = 0;
        for(int i = 1; i < n; i++){
            leftPrefix[i] = leftPrefix[i-1] + nums[i-1];
        }
        for(int i = n - 2; i >= 0; i--){
            rightSuffix[i] = rightSuffix[i+1] + nums[i+1];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = Math.abs(leftPrefix[i] - rightSuffix[i]);
        }
        return ans;
    }
}