class Solution {
    public int totalMoney(int n) {
        int terms = n/7;
        int first = 28;
        int last = 28 + (terms -1) * 7;
        int res = terms * (first + last) /2;
        int startMoney = 1 + terms;

        for(int day = 1; day <= (n%7); day++){
            res += startMoney;
            startMoney++;
        }
        return res;
    }
}