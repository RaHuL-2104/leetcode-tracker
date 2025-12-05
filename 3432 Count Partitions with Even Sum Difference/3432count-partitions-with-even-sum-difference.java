class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        if(n < 2) return 0;
        for(int x : nums) sum +=x;
        int count = 0;
        int leftSum = 0;
        for(int i = 0; i < n-1; i++){
            leftSum += nums[i];
            // No need of iterating the loop to find rightSum
            // for(int j = i + 1; j < n; j++){
            //     rightSum += nums[j];
            // }
            int rightSum = sum - leftSum;
            int diff = leftSum - rightSum;
            if(diff % 2 == 0){
                count++;
            }
        }
        return count;
    }
}