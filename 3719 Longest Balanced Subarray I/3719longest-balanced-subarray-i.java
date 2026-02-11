class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            HashSet<Integer> countEven = new HashSet<>();
            HashSet<Integer> countOdd = new HashSet<>();
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0){
                    countEven.add(nums[j]);
                } else{
                    countOdd.add(nums[j]);
                }
            if(countEven.size() == countOdd.size()){
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        }
        return maxLength;
    }
}