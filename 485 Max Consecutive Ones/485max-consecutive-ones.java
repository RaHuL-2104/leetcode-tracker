class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // int ans = -1;
        // int left = 0;
        // int window = 0;
        // for(int right = 0; right < nums.length; right++){
        //     // add element nums[right] to the window
        //     window += nums[right];
        //     while(right - left + 1 != window){
        //         window -= nums[left];
        //         left++;
        //     }
        //     ans = Math.max(ans, right - left + 1);
        // }
        // return ans;

        int countOnes = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                countOnes++;
                result = Math.max(result, countOnes);
            }else{
                countOnes = 0;
            }
        }
        return result;
    }
}