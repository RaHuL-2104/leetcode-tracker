class Solution {
    public int minimumCost(int[] cost) {
        // 6 5 7 9 2 2 
        // choose 9 and 7 -> we get 6 closest to the min(9,7).
        // choose 5 and 2 -> we get 2 closest to the min(5, 2).
        // Identify the largest and second largest element in costs.
        // 2 2 5 6 7 9
        // skipping the third element
        int sum = 0;
        Arrays.sort(cost);
        for(int i = cost.length - 1; i >= 0; i-=3){
            sum += cost[i];
            if(i - 1 >= 0)sum += cost[i-1];
        }
        return sum;
    }
}