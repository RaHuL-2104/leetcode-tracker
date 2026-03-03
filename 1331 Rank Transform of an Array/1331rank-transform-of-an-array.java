class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        int rank = 0;
        Arrays.sort(temp);
        for(int i = 0; i < n; ++i){
            if(i == 0 || temp[i] != temp[i-1]){
                temp[rank++] = temp[i];
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i){
            ans[i] = Arrays.binarySearch(temp, 0, rank, arr[i]) + 1;
        }
        return ans;
    }
}