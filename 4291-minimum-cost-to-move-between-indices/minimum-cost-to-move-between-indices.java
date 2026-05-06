class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] left = new long[n];
        Arrays.fill(left, 0);
        long[] right = new long[n];
        Arrays.fill(right, 0);

        if(n > 1){
            left[n-1] = 1;
            right[0] = 1;
        }
        for(int i = 1; i < n-1; i++){
            long x = (long)(nums[i] - nums[i-1]);
            long y = (long)(nums[i+1] - nums[i]);
            if(x <= y){
                left[i] = 1;
                right[i] = y;
            }
            else{
                left[i] = x;
                right[i] = 1;
            }
        }

        long[] prefixLeft = new long[n+1];
        Arrays.fill(prefixLeft, 0);
        long[] prefixRight = new long[n+1];
        Arrays.fill(prefixRight, 0);

        for(int i = 0; i < n; i++){
            prefixLeft[i+1] = prefixLeft[i] + left[i];
            prefixRight[i+1] = prefixRight[i] + right[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0], r = queries[i][1];

            if(l < r){
                ans[i] = (int)(prefixRight[r] - prefixRight[l]);
            } else if( l > r){
                ans[i] = (int)(prefixLeft[l+1] - prefixLeft[r+1]);
            } else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}