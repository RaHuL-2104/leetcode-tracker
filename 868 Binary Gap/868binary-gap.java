class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int maxLength = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                for (int j = i + 1; j < binary.length(); j++) {
                    if (binary.charAt(j) == '1') {
                        maxLength = Math.max(maxLength, j - i);
                        break;
                    }
                }
            }
        }
        return maxLength;
    }
}