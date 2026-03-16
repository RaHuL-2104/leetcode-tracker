class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        HashMap<Integer, String> mp = new LinkedHashMap<>();
        mp.put(1000, "M");
        mp.put(900, "CM");
        mp.put(500, "D");
        mp.put(400, "CD");
        mp.put(100, "C");
        mp.put(90, "XC");
        mp.put(50, "L");
        mp.put(40, "XL");
        mp.put(10, "X");
        mp.put(9, "IX");
        mp.put(5, "V");
        mp.put(4, "IV");
        mp.put(1, "I");
        for(Map.Entry<Integer, String> e : mp.entrySet()){
            int key = e.getKey();
            String val = e.getValue();
            while(num >= key){
                num -= key;
                res.append(val);
            }
        }
        return res.toString();
    }
}