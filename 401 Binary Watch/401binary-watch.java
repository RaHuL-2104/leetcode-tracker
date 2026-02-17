class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        // calculate number of set bits 
        // it must be equal to the turnedOn 
        for(int h = 0; h <= 11; h++){
            for(int m = 0; m <= 59; m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    String hour = String.valueOf(h);
                    String minutes = (m < 10 ? "0" : "") + m;
                    res.add(hour + ":" + minutes);
                }
            }
        }
        return res;
    }
}
