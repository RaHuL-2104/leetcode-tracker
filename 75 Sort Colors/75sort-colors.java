class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(mid <= high){
            if(nums[mid] == 0){
                int tmp = nums[low];
                nums[low++] = nums[mid];
                nums[mid++] = tmp;
            } else if(nums[mid] == 1){
                mid++;
            }else{
                int tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = tmp;
            }
        }
    }
}