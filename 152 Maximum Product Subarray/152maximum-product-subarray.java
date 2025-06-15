class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1,currMax = 1;

        for(int num : nums){
            int tmp = currMax * num;
            currMax = Math.max(Math.max(num * currMax, num * currMin),num);
            currMin = Math.min(Math.min(tmp, num * currMin), num);
            res = Math.max(res,currMax);
        }
        return res;
    }

}