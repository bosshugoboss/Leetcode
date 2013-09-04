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
    public ListNode deleteDuplicates(ListNode head) {
 
        if(head == null) return head;
        ListNode current = head.next;
        ListNode prev = head;
        ListNode newHead = head;
        while(current != null){
            if(prev.val == current.val){
                prev.next = current.next;
            }
            else{
                prev = prev.next;
            }
            current = current.next;
        }
        
        return newHead;
    }
}


/* new */
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
    public ListNode deleteDuplicates(ListNode head) {
    
        if(head == null) return head;
        ListNode ahead = head;
        ListNode current = head.next;
        while(current != null){
            if(ahead.val == current.val){
                ahead.next = current.next;
            }
            else{
                ahead = ahead.next;
            }
            current = current.next;      
        }
        return head;
    }
}
