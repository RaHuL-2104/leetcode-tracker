class Solution {
    public long minArraySum(int[] nums) {
        // to minimize the sum -> find the largest element 
        // then find its another number that is divisible by it , must be the smallest number
        // 2 3 6
        // 2 + 3 + 3 = 8
        // 2 + 3 + 2 = 7
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        boolean[] present = new boolean[max + 1];
        for(int num : nums){
            present[num] = true;
        }

        int[] best = new int[max + 1];
        for(int d = 1 ;  d <= max ; d++){
            if(!present[d]) continue;
            for(int m = d; m <= max; m += d){
                if(!present[m]) continue;
                if(best[m] == 0){
                    best[m] = d;
                }
            }
        }

        long ans = 0;
        for(int num : nums){
            ans += best[num];
        }
        return ans;
    }
}