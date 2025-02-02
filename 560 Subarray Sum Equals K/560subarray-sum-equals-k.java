class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, curSum = 0;
        Map<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        for(int num : nums){
            curSum +=num;
            int diff = curSum-k;
            res+=prefixCount.getOrDefault(diff,0);
            prefixCount.put(curSum,prefixCount.getOrDefault(curSum,0)+1);
        }
        return res;
    }
}