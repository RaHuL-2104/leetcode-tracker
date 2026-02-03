class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length < 4) return false;
        int n = nums.length;
        int i = 0;
        //strictly increasing check
        while(i+1 < n && nums[i] < nums[i+1]){
            i++;
        }
        if(i == 0 || i == n-1) return false; // checking for strictly decreasing / strictly increasing
        // strictly decreasing check
        int p = i;
        while(i+1 < n && nums[i] > nums[i+1]){
            i++;
        }
        if(i == p || i == n-1) return false; // checking for strictly increasing / strictly decreasing
        // strictly increasing check
        while(i+1 < n && nums[i] < nums[i+1]){
            i++;
        }
        return i == n-1;
    }
}