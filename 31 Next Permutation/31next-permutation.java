class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breaking_idx = -1;
        for(int i = n-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                breaking_idx = i - 1;
                break;
            }
        }
        if(breaking_idx != -1){
            int swap_idx = breaking_idx;
            for(int j = n - 1; j >= breaking_idx + 1; j--){
                if(nums[j] > nums[breaking_idx]){
                    swap_idx = j;
                    break;
                }
            }
            int temp = nums[breaking_idx];
            nums[breaking_idx] = nums[swap_idx];
            nums[swap_idx] = temp;
        }

        int left = breaking_idx+1;
        int right = n - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}