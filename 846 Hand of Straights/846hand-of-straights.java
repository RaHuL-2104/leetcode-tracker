class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0)+ 1);
        }

        while(!map.isEmpty()){
            int current = map.firstKey();

            for(int i = 0; i < groupSize; i++){
                if(!map.containsKey(current + i)){
                    return false;
                }

                map.put(current + i, map.get(current + i) - 1);
                if(map.get(current + i) == 0){
                    map.remove(current + i);
                }
            }
        }
        return true;
    }
}