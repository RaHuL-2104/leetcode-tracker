class Solution {
    public int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            while(l <= r){
                nums[l] = (int)((1L*nums[l]*v)% MOD);
                l += k;
            }
        }
        int res = 0;
        for(int n : nums){
            res = res^n;
        }
        return res;
    }
}