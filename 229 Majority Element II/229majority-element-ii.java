class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // HashMap<Integer,Integer> mp = new HashMap<>();
        // ArrayList<Integer> res = new ArrayList<>();
        // for(int n : nums){
        //     mp.put(n, mp.getOrDefault(n, 0) + 1);
        // }
        // for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
        //     if(entry.getValue() > nums.length/3){
        //         res.add(entry.getKey());
        //     }
        // }
        // return res;
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && nums[i] != element2){
                count1++;
                element1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != element1){
                count2++;
                element2 = nums[i];
            }
            else if(element1 == nums[i]) count1++;
            else if(element2 == nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(element1 == nums[i]) count1++;
            if(element2 == nums[i]) count2++;
        }
        int minVal = (int)(nums.length/3) + 1;
        if(count1 >= minVal) res.add(element1);
        if(count2 >= minVal) res.add(element2);
        return res;
    }
}