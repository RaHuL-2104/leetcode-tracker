class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for(var e: map.entrySet()){
            if(e.getValue() % 2 == 0){
                minEven = Math.min(minEven,e.getValue());
            }else{
                maxOdd = Math.max(maxOdd,e.getValue());
            }
        }
        return maxOdd - minEven;
    }
}