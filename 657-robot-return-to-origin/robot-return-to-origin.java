class Solution {
    public boolean judgeCircle(String moves) {
        // take hashmap to store character and its values
        // then check character by character and count the totalSum
        // if totalSum is 0 return true
        // HashMap<Character, Integer> mp = new HashMap<>();
        // mp.put('U', 1);
        // mp.put('D', -1);
        // mp.put('L', -1);
        // mp.put('R', 1);
        // int totalSum = 0;
        // for(char ch : moves.toCharArray()){
        //     for(Map.Entry<Character, Integer> e : mp.entrySet()){
        //         if(e.getKey() == ch){
        //             totalSum += e.getValue();
        //         }
        //     }
        // }
        // if(totalSum == 0){
        //     return true;
        // }
        // return false;
        int x = 0, y = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'U') y++;
            if(ch == 'D') y--;
            if(ch == 'L') x--;
            if(ch == 'R') x++;
        }
        return (x==0) && (y==0);
    }
}