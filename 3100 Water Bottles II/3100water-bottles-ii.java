class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottles = numBottles;

        while(emptyBottles >= numExchange){
            emptyBottles -= numExchange;
            numExchange += 1;
            result += 1;
            emptyBottles += 1;
        }
        return result;
    }
}