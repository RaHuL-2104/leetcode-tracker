class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxLucky = -1;

        for(int i = 0 ; i < n;){
            int curr = arr[i];
            int count = 0;

            while(i < n && arr[i] == curr){
                count++;
                i++;
            }

            if(count == curr){
                maxLucky = Math.max(maxLucky, curr);
            }
        }
        return maxLucky;
    }
}