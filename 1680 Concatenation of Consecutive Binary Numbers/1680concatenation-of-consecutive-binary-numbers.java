class Solution {
    public int concatenatedBinary(int n) {
        // convert all decimal to binary 
        // append them together 
        // convert them back to decimal and mod them
        // wont work
        int MOD = 1000000007;
        long result = 0;
        for(int i = 1; i <= n; i++){
            // iss number ko binary mein represent karne ke liye kitne bits chahiye honge
            int digits = (int)(Math.log(i) / Math.log(2)) + 1;
            result = ((result << digits) % MOD + i) % MOD;
        }
        return (int) result;
    }
}