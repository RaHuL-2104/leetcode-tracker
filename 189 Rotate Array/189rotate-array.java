class Solution {
    public void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        // reverse the first half of the array uptil k
        // reverse the second half of the array from k to n
        // reverse the whole array
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k , n - 1);
        reverse(nums, 0, n - 1);
        
    }
}