class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        // Rotating 2D matrix by 90
        char[][] res = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res[i][j] = boxGrid[j][i];
            }
        }
        for(int i = 0; i < n; i++){
            reverseRow(res[i]);
        }
        for(int j = 0; j < m; j++){
            int bottomRow = n - 1;
            for(int i = bottomRow; i >= 0; i--){
                if(res[i][j] == '*'){
                    bottomRow = i-1;
                    continue;
                }
                if(res[i][j] == '#'){
                    res[i][j] = '.';
                    res[bottomRow][j] = '#';
                    bottomRow--;
                }
            }
        }
        return res;
    }

    private void reverseRow(char[] row){
        int left = 0, right = row.length - 1;
        while(left < right){
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}