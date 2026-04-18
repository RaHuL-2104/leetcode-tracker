class Solution {
    public int reverseInteger(int n){
        int rev = 0;
        while(n != 0){
            int d = n%10;
            rev = rev*10 + d;
            n = n/10;
        }
        return rev;
    }
    public int mirrorDistance(int n) {
        int rev = reverseInteger(n);
        return Math.abs(n - rev);
    }
}