class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* View the problem like this: a + b + c = 0
            a + b = - c
            fix c in the array and find the two numbers that are equal to it (i.e. a+b)
            similar to the 2sum problem
            to avoid duplicate calculation of two sum check whether the number you have fixed is unique and has not been repeated
        */

        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // fixing one element
        for(int i =0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSum(nums, i + 1, result, -nums[i]);
        }
        return result;
    }

    private void twoSum(int[] nums, int k, List<List<Integer>> res, int target){
        int i = k, j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] > target){
                j--;
            }else if(nums[i] + nums[j] < target){
                i++;
            } else{
                // removing duplicates from either ends (i,j)
                while(i < j && nums[i] == nums[i+1]){
                    i++;
                }
                while(i < j && nums[j] == nums[j-1]){
                    j--;
                }
                 res.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }
}