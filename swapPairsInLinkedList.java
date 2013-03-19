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
    public ListNode swapPairs(ListNode head) {
         if(head == null || head.next == null) return head;
         ListNode firstPointer = head;
         ListNode secondPointer = head.next;
         ListNode prev = head;
         ListNode newHead = null;
         while(firstPointer != null && secondPointer != null){
             if(firstPointer == head){
              firstPointer.next = secondPointer.next;
              secondPointer.next = firstPointer;
              newHead = secondPointer;             
             }
             else{
              prev.next = secondPointer;
              firstPointer.next = secondPointer.next;
              secondPointer.next = firstPointer;
             }
             prev = firstPointer;
             firstPointer = firstPointer.next;
             if(firstPointer != null)
             secondPointer = firstPointer.next;
         }
         return newHead;
    }
}
