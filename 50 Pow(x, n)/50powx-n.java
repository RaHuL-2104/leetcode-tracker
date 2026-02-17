class Solution {
    public double solve(double x, long n){
        if(n == 0) return 1.0;
        if(n < 0){
            return 1/solve(x, -n);
        }
        if(n % 2 == 0){
            return solve(x*x, n/2);
        }
        return x * solve(x*x, (n-1)/2);
    }
    public double myPow(double x, int n) {
        // TLE SOLUTION
        // double res = 1.0;
        // if(n < 0){
        //     n = -1*n;
        //     x = 1/x;
        // }
        // for(int i = 0; i < n; i++){
        //     res = res * x;
        // }
        // return res;
        // FOR EVEN POWERS = call recursive fn till n/2 and perform x*x
        // FOR ODD POWERS = x * call recursice fn till (n-1)/2 and perform x*x
        // FOR NEGATIVE POWERS = x -> 1/x and pass -ve of n which would make it positive
        return solve(x, (long)n);
    }
}