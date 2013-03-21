/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example.
 * Given 1->2->3->4->5->NULL and k = 2,return 4->5->1->2->3->NULL.
 */ 
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
           if(n == 0 || head == null) return head;
           ListNode bottom = head;
           int length = 0;
           while(bottom != null){
               length ++;
               bottom = bottom.next;
           }
           int rotate = (n - 1) % length;
           ListNode newHead = head;
           bottom = head;
           ListNode prev = null;
           while(bottom.next != null && rotate > 0){
               rotate --;
               bottom = bottom.next;
           }
           while(bottom.next != null){
               prev = newHead;
               newHead = newHead.next; 
               bottom = bottom.next;               
           }
           if(prev == null) return newHead;
           prev.next = null;
           bottom.next = head;
           return newHead;
    }
}
