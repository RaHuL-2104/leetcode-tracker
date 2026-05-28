class Solution {
    public int minimumSwaps(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) if(nums[i] == 0) count++;
        int ans = 0;
        for(int i = 0; i < n-count; i++) if(nums[i] == 0) ans++;
        return ans;
    }
}

// 0 1 0 3 12
// count = 2

// 0 1 0 2
// count = 2
