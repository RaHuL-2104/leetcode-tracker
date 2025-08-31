class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] temp = nums.clone();
        Arrays.sort(temp);

        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(temp[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            temp[i] = map.get(nums[i]);
        }
        return temp;
    }
}