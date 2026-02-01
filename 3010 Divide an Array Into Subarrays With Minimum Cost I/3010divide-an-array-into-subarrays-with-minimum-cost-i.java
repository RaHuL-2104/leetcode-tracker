class Solution {
    public int minimumCost(int[] nums) {
        // ek subarray should contain the minimum number
        // cannot skip the first element because any subarray we try would always contain it
        // cost = nums[0] + minimum element + second minimum element
        int n = nums.length;
        int cost = nums[0];
        int minElement = Integer.MAX_VALUE;
        int secondMinElement = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
           if(minElement > nums[i]){
            secondMinElement = minElement;
            minElement = nums[i];
           } else if(nums[i] < secondMinElement){
            secondMinElement = nums[i];
           }
        }
        cost += minElement + secondMinElement;
        return cost;
    }
}