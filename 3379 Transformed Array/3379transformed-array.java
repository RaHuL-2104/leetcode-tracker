class Solution {
    public int[] constructTransformedArray(int[] nums) {
        // circular array must have something to do with n%i 
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            // right shift
            if(nums[i] > 0){
                res[i] = nums[(i+nums[i])%n];
            }
            // left shift
            else if(nums[i] < 0){
                res[i] = nums[(i - Math.abs(nums[i]) % n + n)%n];
            } else{
                res[i] = nums[i];
            }
        }
        return res;
    }
}
