class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int maxVal = nums[0];
        int minVal = nums[0];
        long total = 0;
        for(int i = 0; i < n; i++){
            maxVal = Math.max(maxVal, nums[i]);
            minVal = Math.min(minVal, nums[i]);
            total = maxVal - minVal;
        }
        return (long) total*k;
    }
}