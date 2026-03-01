class Solution {
    public int minPartitions(String n) {
        // brute force
        // char[] arr = s.toCharArray(n);
        // int count = 0;
        // while(true){
        //     boolean changed = false;
        //     for(int i = 0; i < arr.length; i++){
        //         if(arr[i] != 0){
        //             arr[i]--;
        //             changed = true;
        //         }
        //     }
        //     if(!changed){
        //         break;
        //     }
        //     count++;
        // }
        // return count;
        char maxChar = '0';
        for(char ch : n.toCharArray()){
            maxChar = (char)Math.max(maxChar, ch);
        }
        return maxChar - '0';
    }
}