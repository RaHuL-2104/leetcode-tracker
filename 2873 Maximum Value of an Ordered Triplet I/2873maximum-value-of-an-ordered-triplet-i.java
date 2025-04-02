class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMaxi = new int[n];
        int[] rightMaxk = new int[n];
        for(int j = 1; j< n ; j++){
            leftMaxi[j] = Math.max(leftMaxi[j-1],nums[j-1]);
        }
        for(int j = n-2; j >=0 ; j--){
            rightMaxk[j] = Math.max(rightMaxk[j+1],nums[j+1]);
        }
        long res = 0;
        for(int j = 1; j < n; j++){
            res = Math.max(res,(long)(leftMaxi[j]-nums[j])*rightMaxk[j]);
        }
        return res;
    }
}