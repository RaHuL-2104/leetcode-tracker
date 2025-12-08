class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int a = 1; a <= n; a++){
            for(int b = a+1; b <= n; b++){
                int sum = (a*a)+(b*b);
                int sqrt = (int)Math.sqrt(sum);
                if(sqrt <= n && (sqrt*sqrt) == sum){
                    count+=2;
                }
            }
        }
        return count;
    }
}