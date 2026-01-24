class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0 , r = nums.length - 1;
        int maxSum = Integer.MIN_VALUE;
        while(l <= r){
            int sum = 0;
            sum += (nums[l] + nums[r]);
            maxSum = Math.max(maxSum, sum);
            l++;
            r--; 
        }
        return maxSum;
    }
}