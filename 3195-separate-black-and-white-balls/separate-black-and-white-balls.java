class Solution {
    public long minimumSteps(String s) {
        //number of black balls after white = the minimum number of swaps
        int n = s.length();
        long swaps = 0;
        int black = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                swaps += black;
            } else{
                black++;
            }
        }
        return swaps;
    }
}