class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Similar to a three sum problem, Find the sum of the triplet and find minimumDifference.
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(currentSum - target);

                if(currentDiff < minDiff){
                    minDiff = currentDiff;
                    closestSum = currentSum;
                }
                if(currentSum < target){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return closestSum;
    }
}