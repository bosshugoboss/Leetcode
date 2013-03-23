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
        ListNode newHead = null;
        ListNode newcurrent = null;
        ListNode current = head;
        ListNode temp = current;
        while(current != null){
            temp = findNext(current);
            if(temp == current){
                if(newHead == null) {
                  newHead = new ListNode(temp.val);
                  newcurrent = newHead;
                }
                else{
                  newcurrent.next = new ListNode(temp.val);
                  newcurrent = newcurrent.next;
                }
            }
            current = temp.next;            
        }
        return newHead;
     }
    
    public ListNode findNext(ListNode node){
           ListNode result = node;
           while(result.next != null){
               if(result.val == result.next.val)
                  result = result.next;
               else return result;
           }
           return result;
    }
}
