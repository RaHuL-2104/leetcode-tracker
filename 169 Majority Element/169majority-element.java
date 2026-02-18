class Solution {
    public int majorityElement(int[] nums) {
        // int len = nums.length;
        // HashMap<Integer, Integer> mp = new HashMap<>();
        // for(int n : nums){
        //     mp.put(n, mp.getOrDefault(n, 0) + 1);
        // }
        // // 2 1
        // // 3 2
        // for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
        //     if(entry.getValue() > len/2){
        //         return entry.getKey();
        //     }
        // }
        // return 0;
        // Moore Voting Algorithm
        int count = 0;
        int candidate = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}