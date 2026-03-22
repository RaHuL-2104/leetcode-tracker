class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // two sum problem
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            twoSum(nums, res, i+1, -nums[i]);
        }
        return res;
    }
    private void twoSum(int[] nums, List<List<Integer>> res, int left, int target){
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] > target) {
                right--;
            } else if(nums[left] + nums[right] < target){
                left++;
            }
            else{
                res.add(Arrays.asList(-target ,nums[left], nums[right]));
                while(left < right && nums[left] == nums[left+1]){
                    left++;
                }
                while(left < right && nums[right-1] == nums[right]){
                    right--;
                }
                left++;
                right--;
            }
        }
    }
}