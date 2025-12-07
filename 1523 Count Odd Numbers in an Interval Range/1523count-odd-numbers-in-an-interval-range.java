class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if(low % 2 == 0) low++;
        if(high % 2 == 0) high--;
        if(low > high) return 0;
        
        return (high - low)/2 + 1;
    }
}