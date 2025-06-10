class Solution {
    public int lengthOfLIS(int[] nums) {
        // Patience Sorting
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int indx = binarySearch(sorted, nums[i]);
            if(indx == sorted.size())
                sorted.add(nums[i]);
            else
                sorted.set(indx, nums[i]);
        }
        return sorted.size();
        //  Bottom-Up Approach
        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp,1);
        // int maxLIS = 1;
        // for(int i = 0; i < n;i++){
        //     for(int j = 0; j < i;j++){
        //         if(nums[j] < nums[i]){
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //             maxLIS = Math.max(maxLIS, dp[i]);
        //         }
        //     }
        // }
        // return maxLIS;
    }
    private int binarySearch(List<Integer> sorted, int target){
        int l = 0,r = sorted.size();
        int res = sorted.size();
        while(l < r){
            int mid = l+(r-l)/2;
            if(sorted.get(mid) < target){
                l = mid + 1;
            }
            else{
                res = mid;
                r = mid;
            }
        }
        return res;
    }
}

/* Memoization (Top-Down Approach)
    int n;
    int t[2501][2501];
    int solve(int[] nums,int i, int P){
        if(i >= n) return 0;
        if(P != -1 && t[i][P] != -1){
            return t[i][P];
        }
        int take = 0;
        if(P == -1 || nums[i] > nums[P]){
            take = 1 + solve(nums, i+1, P);
        }
        int skip = solve(nums, i+1, P);
        if(P != -1) 
            t[i][P] = Math.max(take,skip);
        return Math.max(take,skip);
    } 
    public int lengthofLIS(int[] nums){
        int n = nums.length;
        for(int i = 0; i < t.length; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(nums, 0, -1);
    }

 */