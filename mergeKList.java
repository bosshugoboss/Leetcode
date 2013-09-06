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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
         ListNode head = null;
         ListNode prev = null;
         for(ListNode node : lists){
             if(node != null){
             if(prev == null){
                 prev = node;
                 head = node;
                 continue;
             }
             else{
                 head = merge2List(prev, node);
                 prev = head;
              }
             }
         }
         return head;
    }
    
    private ListNode merge2List(ListNode l1, ListNode l2){
         ListNode head = null;
         ListNode tail = null;
         ListNode c1 = l1;
         ListNode c2 = l2;
         while(c1 != null && c2 != null){
             if(c1.val < c2.val){
                 if(head == null){
                     head = new ListNode(c1.val);
                     tail = head;
                 }
                 else{
                     tail.next = new ListNode(c1.val);
                     tail = tail.next;
                 }
                 c1 = c1.next;
             }
             else{
                 if(head == null){
                     head = new ListNode(c2.val);
                     tail = head;
                 }
                 else{
                     tail.next = new ListNode(c2.val);
                     tail = tail.next;
                 }
                 c2 = c2.next;
             }
         }
         if(c1 != null) tail.next = c1;
         else if(c2 != null) tail.next = c2;
         return head;
    }
}
