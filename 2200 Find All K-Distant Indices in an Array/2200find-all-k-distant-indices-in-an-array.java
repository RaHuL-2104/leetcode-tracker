class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // Approach -> Simply iterating and finding the valid indices, need to be careful of overlapping indices and the corner cases
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int j = 0; j < n; j++){
            if(nums[j] == key){
                int start = Math.max(j - k, 0);
                int end = Math.min(j + k, n-1);

                // Avoiding duplicates
                if(!res.isEmpty() && res.get(res.size() - 1) >= start){
                    start = res.get(res.size() - 1) + 1;
                }

                for(int i = start; i <= end; i++){
                    res.add(i);
                }
            }
        }
        return res;
    }
}