class Solution {
    public int firstMissingPositive(int[] nums) {
        // finding if the array contains 1's
        int n = nums.length;
        boolean containsOne = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) containsOne = true;
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        if(!containsOne) return 1;

        // marking whether the integers 1 to n are in nums
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);
            int index = val - 1;
            if(nums[index] < 0) continue;
            nums[index] *= -1;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n+1;
    }
}