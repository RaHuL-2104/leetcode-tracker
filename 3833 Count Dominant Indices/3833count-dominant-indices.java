class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int dominant = 0;
        for(int i = 0; i < n - 1; i++){
            double sum = 0;
            int count = 0;
            for(int j = i + 1; j < n; j++){
                sum += nums[j];
                count++;
            }
            if(nums[i] > sum/count){
                dominant++;
            }
        }
        return dominant ;
    }
}

// 5
// 