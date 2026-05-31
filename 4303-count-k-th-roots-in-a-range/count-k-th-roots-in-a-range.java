class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1){
            return r-l+1;
        }
        int count = 0;
        int large = (int)Math.pow(r, 1.0/k) + 1;
        for(int x = 0; x <= large; x++){
            long y = Math.round(Math.pow(x, k));
            if(y <= r && y >= l){
                count++;
            }
        }
        return count;
    }
}