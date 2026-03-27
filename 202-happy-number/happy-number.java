class Solution {
    public boolean isHappy(int n) {
        // Using hashset to keep a track of the numbers
        // If number isn't happy, there are chances of the number being repeated again.
        HashSet<Integer> hs = new HashSet<>();
        while(true){
            int sum = 0;
            while(n != 0){
                int d = n%10;
                sum += Math.pow(d, 2.0);
                n = n/10;
            }
            if(sum == 1) return true;
            n = sum;
            if(hs.contains(n)){
                return false;
            }
            hs.add(n);
        }
    }
}
