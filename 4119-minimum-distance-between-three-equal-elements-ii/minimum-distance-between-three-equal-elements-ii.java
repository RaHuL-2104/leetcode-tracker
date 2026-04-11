class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int result = n;
        for(int i = 0; i < n; i++){
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
            if(mp.get(nums[i]).size() >= 3){
                List<Integer> list = mp.get(nums[i]);
                int s = list.size();
                int j = list.get(s - 3);
                result = Math.min(result, i-j);
            }
        }
        return result >= n ? -1 : 2 * result;
    }
}