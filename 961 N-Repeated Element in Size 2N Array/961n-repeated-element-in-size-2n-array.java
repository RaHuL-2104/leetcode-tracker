class Solution {
    public int repeatedNTimes(int[] nums) {
        // Map<Integer,Integer> mp = new HashMap<>();
        // for(int x : nums){
        //     mp.put(x,mp.getOrDefault(x,0) + 1);
        // }
        // for(Map.Entry<Integer, Integer> e : mp.entrySet()){
        //     if(e.getValue() > 1){
        //         return e.getKey();
        //     }
        // }
        // return 0;
        int n = nums.length;
        for(int i = 2; i < n; i++){
            if(nums[i] == nums[i-1] || nums[i] == nums[i-2])
                return nums[i];
        }
        return nums[n - 1];
    }
}