class Solution {
    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n%10, 2.0);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        // Using hashset to keep a track of the numbers
        // If number isn't happy, there are chances of the number being repeated again.
        // HashSet<Integer> hs = new HashSet<>();
        // while(true){
        //     int sum = 0;
        //     while(n != 0){
        //         int d = n%10;
        //         sum += Math.pow(d, 2.0);
        //         n = n/10;
        //     }
        //     if(sum == 1) return true;
        //     n = sum;
        //     if(hs.contains(n)){
        //         return false;
        //     }
        //     hs.add(n);
        // }
        // Similar concept with the help of two pointers
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
