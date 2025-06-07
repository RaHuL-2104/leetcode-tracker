
/*
1. Sort all capital and profit pairs in ascending order of capital value.
2. Start with your initial capital w. Add all the projects that we can afford in a storage. This storage will have values in descending order of profit!
3. Pick the best project with maximum profit. And mark on purchase done, also increase our capital by the profit value.
4. With new capital, repeat step 2 and 3 until we have made all the required purchases.
*/

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0;i < n; i++){
            arr.add(new int[]{capital[i],profits[i]});
        }
        arr.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(k-- > 0){
            while(i < n && arr.get(i)[0] <= w){
                maxProfitHeap.add(arr.get(i)[1]);
                i++;
            }
            if(maxProfitHeap.isEmpty()){
                break;
            }
            w += maxProfitHeap.poll();
        }
        return w;
    }
}