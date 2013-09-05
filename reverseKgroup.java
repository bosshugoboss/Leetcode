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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        int length = 0;
        while(current != null){
            length ++;
            current = current.next;
        }
        return reverseRec(head, k, 1, length);
    }
    
    private ListNode reverseRec(ListNode newHead, int k, int group, int length){
        int step = k;
        if(k * group > length) return newHead;
        ListNode current = newHead;        
        ListNode next = newHead.next;
        ListNode temp = null;
        while(next != null && step > 1){
            temp = next;
            next = next.next;
            temp.next = current;
            current = temp;
            step --;
        }
        newHead.next = reverseRec(next, k, group + 1,length);
        return current;
    }
}
