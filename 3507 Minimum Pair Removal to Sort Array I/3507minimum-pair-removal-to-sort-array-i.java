class Solution {
    public int minimumPairRemoval(int[] nums) {
        // int count = 0;
        // int minimumPairSum = Integer.MAX_VALUE;    
        // for(int i = 0; i < nums.length; i++){
        //     if(i+1 != nums.length){
        //         int sum = nums[i] + nums[i+1]; 
        //         minimumPairSum = Math.min(minimumPairSum, sum);
        //     }
        //     // minimumPairSum = Math.min(minimumPairSum, sum);
        //     nums[i] = minimumPairSum;
        //     // count++;
        // }
        // // return count;
        // for(int n : nums){
        //     System.out.print(n);
        // }
        // return 0;
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        int count = 0;
        while(!isDecreasing(list)){
            int minimumPairSum = Integer.MAX_VALUE;
            int targetIndex = -1;
            for(int i = 0; i < list.size() - 1; i++){
                    int sum = list.get(i) + list.get(i+1);
                    if(sum < minimumPairSum){
                        minimumPairSum = sum;
                        targetIndex = i;
                    }
            }
            if(targetIndex != -1){
                int sum = list.get(targetIndex) + list.get(targetIndex+1);
                list.set(targetIndex, sum);
                list.remove(targetIndex+1);
                count++;
            } else{
                break;
            }
        }
        return count;
    }
    private boolean isDecreasing(List<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
// Finding minimum of i and i + 1, replacing its sum and reducing the array until the non-decreasing condition is met.