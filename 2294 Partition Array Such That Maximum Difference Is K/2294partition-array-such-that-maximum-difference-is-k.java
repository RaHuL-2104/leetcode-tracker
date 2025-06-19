class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int minVal = nums[0];
        int count = 1;
        for(int i = 0 ; i < n ;i++){
            if(nums[i] - k > minVal){
                count++;
                minVal = nums[i];
            }
        }
        return count;
    }
}