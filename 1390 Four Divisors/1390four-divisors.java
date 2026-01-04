class Solution {
    private int countDivisors(int num){
        int divisors = 0;
        int sum = 0;

        for(int div = 1; div * div <= num; div++){
            if(num % div == 0){
                int other = num/div;
                if(div == other){
                    divisors++;
                    sum += div;
                }else{
                    divisors += 2;
                    sum += div + other;
                }
            }
            if(divisors > 4){
                return 0;
            }
        }
        return divisors == 4 ? sum : 0;
    }
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int n : nums){
            res += countDivisors(n);
        }
        return res;
    }
}