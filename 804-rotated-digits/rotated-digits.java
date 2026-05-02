        // Optimized solution - using DP
        // Repeating recursive pattern of finding the last digit of the number then breaking the    number (n/=10) 
        // 0 1 8 -> digit does not change after rotating but isn't invalid
        // 2 5 6 9 -> digit changes after rotating and is valid
        // 3 4 7 -> digit is invalid after rotating

class Solution {
    // int[] t;
    // public int solve(int num){
    //     if(t[num] != -1) return t[num];

    //     if(num == 0) return t[num] = 0;

    //     int remain = solve(num/10);

    //     if(remain == 2)
    //         return t[num] = 2;

    //     int digit_check;
    //     int d = num % 10;

    //     if(d == 0 || d == 1 || d == 8)
    //         digit_check = 0;
    //     else if(d == 2 || d == 5 || d == 6 || d == 9)
    //         digit_check = 1;
    //     else 
    //         return t[num] = 2;
        
    //     if(remain == 0 && digit_check == 0) return t[num] = 0;
        
    //     return t[num] = 1;
    public int rotatedDigits(int n) {
        // 0 : same
        // 1 : changed
        // 2 : invalid
        // t = new int[n+1];
        // Arrays.fill(t, -1);
        // int count = 0;
        // for(int i = 1; i <= n; i++){
        //     if(solve(i) == 1){
        //         count++;
        //     }
        // }
        // return count;


        // Bottom-Up Approach

        int[] t = new int[n + 1];
        Arrays.fill(t, -1);

        t[0] = 0;

        int count = 0;

        for(int i = 1; i <= n; i++){
            int remain = t[i/10];

            if(remain == 2){
                t[i] = 2;
                continue;
            }
            int d = i % 10;
            int digitCheck;

            if(d == 0 || d == 1 || d == 8){
                digitCheck = 0;
            } else if(d == 2 || d == 5 || d == 6 || d == 9){
                digitCheck = 1;
            } else{
                t[i] = 2;
                continue;
            }

            if(remain == 0 && digitCheck == 0){
                t[i] = 0;
            }
            else{
                t[i] = 1;
            }

            if(t[i] == 1){
                count++;
            }
        }
        return count;
    }
}