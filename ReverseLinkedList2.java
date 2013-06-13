/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m >= n) return head;
        ListNode start = head;
        ListNode prev = null;
        for(int i = 1; i < m; i ++){
            prev = start;
            start = start.next;
        }
        int length = n - m;
        ListNode tempNext = start.next;
        for(int i = 1; i <= length; i ++){
            ListNode tempNext1 = tempNext.next;
            tempNext.next = start;
            start = tempNext;
            tempNext = tempNext1;
        }
        if(m == 1){
            head.next = tempNext;
            return start;
        }
        
        prev.next.next = tempNext;
        prev.next = start;
        return head;
    }
}
