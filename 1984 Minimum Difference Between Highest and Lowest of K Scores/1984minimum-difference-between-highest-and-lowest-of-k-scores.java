class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        // if(nums.length <= 1) return 0;
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i+1; j < nums.length; j++){
        //         int difference = Math.abs(nums[j] - nums[i]);
        //         minDiff = Math.min(minDiff, difference);
        //     }
        // }
        // return minDiff;
        Arrays.sort(nums);
        for(int i = 0; i + k - 1 < nums.length; i++){
            int diff = nums[i+k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}