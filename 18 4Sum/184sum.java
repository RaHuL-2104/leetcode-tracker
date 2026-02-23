class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // In this approach, we loop through i,j,k find whether the fourth element exists in the hashset between the j and kth element
        // fourth element would intially be target - sum of the three elements
        // T.C => O(N^3) and S.C => O(N).
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j < n; j++){
        //         HashSet<Long> seen = new HashSet<>();
        //         for(int k = j+1; k < n; k++){
        //             long fourth = (long) target - nums[i] - nums[j] - nums[k];
        //             if(seen.contains(fourth)){
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //             seen.add((long)nums[k]);
        //         }
        //     }
        // }
        // return new ArrayList<>(set);
        
        // Using two pointer with the first two numbers being fixed.
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = n-1;
                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // agar duplicate nikal gaye toh move forward
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if(sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }
}