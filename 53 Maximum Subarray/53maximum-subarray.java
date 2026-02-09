class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            // for(int j = i; j < nums.length; j++){
            //     sum += nums[j];
            //     // for(int k = i; k <= j; k++){
            //     //     sum+=nums[k]; 
            //     // }
            //     maxSum = Math.max(maxSum, sum);
            // }

            //adding current element to the sum
            sum += nums[i];

            // checking if the current sum is greater than the maximum
            if(sum > maxSum){
                maxSum = sum;
            }

            // resetting the sum if it goes below zero
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}