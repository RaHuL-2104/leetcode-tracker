class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // nums = 5 0 1 4
        // prefixMax = 5 5 5 5
        // suffixMin = 0 0 1 4
        int n = nums.length;
        int score = 0;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);     
        }
        suffixMin[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }
        for(int i = 0; i < n; i++){
            score = prefixMax[i] - suffixMin[i];
            if(score <= k) return i;
        }
        return -1;
    }
}