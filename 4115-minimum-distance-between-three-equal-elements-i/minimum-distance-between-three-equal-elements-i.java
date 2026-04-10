class Solution {
    public int minimumDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        int n = nums.length;
        if(n  < 3) return -1;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int distance = 0;
                for(int k = j+1; k < n; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k] && nums[i] == nums[k]){
                        distance += Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i);
                        minDist = Math.min(minDist, distance);
                        flag = true;
                    }
                }
            }
        }
        return flag ? minDist : -1;
    }
}