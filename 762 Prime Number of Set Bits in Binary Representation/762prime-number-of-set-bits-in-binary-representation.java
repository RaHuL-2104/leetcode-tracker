class Solution {
    public int countPrimeSetBits(int left, int right) {
        // for checking set bits use Integer.bitCount()
        // check if its prime
        int count = 0;
        for(int i = left; i <= right; i++){
            int setBits = Integer.bitCount(i);
            if(checkPrime(setBits)){
                count++;
            }
        }
        return count;
    }
    public boolean checkPrime(int setBits){
        if(setBits <= 1) return false;
        for(int i = 2; i * i <= setBits; i++){
            if(setBits % i == 0) return false;
        }
        return true;
    }
}