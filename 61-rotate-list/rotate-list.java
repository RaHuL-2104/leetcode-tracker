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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) return head;
        // length nikal lo ll ka 
        int length = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        // connect tail node to head
        k = k % length;
        if(k == 0) return head;
        tail.next = head;
        // calculate remaining nodes = l - k
        int steps = length - k;
        // identify new tail node = last node of remaining node
        ListNode newTail = head;
        for(int i = 1; i < steps; i++){
            newTail = newTail.next;
        }
        // new tail node ka next would be = new head
        ListNode newHead = newTail.next;
        // new tail node ka next would point to null
        newTail.next = null;

        return newHead;
    }
}