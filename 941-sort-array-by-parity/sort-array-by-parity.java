class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] % 2 != 0 && nums[right] % 2 == 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if(nums[left] % 2 == 0){
                left++;
            } else{
                right--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[i];
        }
        
        return res;
    }
}