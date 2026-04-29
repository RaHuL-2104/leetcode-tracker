/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = -1;
            }
        }
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int id = 0;

        while(top <= bottom && left <= right && head != null){
            if(id == 0){
                for(int i = left; i <= right && head != null; i++){
                    res[top][i] = head.val;
                    head = head.next;
                }
                top++;
            }
            else if(id == 1){
                for(int i = top; i <= bottom && head != null; i++){
                    res[i][right] = head.val;
                    head = head.next;
                }
                right--;
            }
            else if(id == 2){
                for(int i = right; i >= left && head != null; i--){
                    res[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }
            else if(id == 3){
                for(int i = bottom; i >= top && head != null; i--){
                    res[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            id = (id+1)%4;
        }
        return res;
    }
}