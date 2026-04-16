class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> answer = new ArrayList<>();
        // Map for storing unique element , List of Indices
        HashMap <Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i); 
        }
        // 1 - 0,2,4
        // 3 - 1,5
        // 4 - 3
        // 2 - 6
        for(int queryIdx : queries){
            int target = nums[queryIdx];
            // in hashmap search if target value has more a list length of >= 2, if so return the minimum between straight and circular distance, from the list of indicies for the target.
            List<Integer> indicies = mp.get(target);
            int len = indicies.size();
            if(len == 1){
                answer.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(indicies, queryIdx);
            int res = Integer.MAX_VALUE;

                // finding right neighbor
            int right = indicies.get((pos + 1) % len);
            int straightDist = Math.abs(queryIdx - right);
            int circularDist = nums.length - straightDist;
            res = Math.min(res, Math.min(straightDist, circularDist));

                // finding left neighbor
            int left = indicies.get((pos - 1 + len) % len);
            straightDist = Math.abs(queryIdx - left);
            circularDist = nums.length - straightDist;
            res = Math.min(res, Math.min(straightDist, circularDist));

            answer.add(res);
        }
    return answer;
    }
}