class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}