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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode thirdPointer = null;
        ListNode head = null;
        int carry = 0;
        int value = 0;
        while(l1 != null || l2 != null){
            if(l1 == null) 
              value = l2.val + carry;
            else if(l2 == null)
              value = l1.val + carry;
            else
              value = l1.val + l2.val + carry;
            if(value >= 10) carry = 1;
            else carry = 0;
            int newValue = value % 10;
            if(thirdPointer == null){
                thirdPointer = new ListNode(newValue);
                head = thirdPointer;
            }
            else{
                thirdPointer.next = new ListNode(newValue);
                thirdPointer = thirdPointer.next;            
            }
            if(l1 != null) // easy to ignore
            l1 = l1.next;
            if(l2 != null) // easy to ignore
            l2 = l2.next;
        }
        if(carry == 1){
            thirdPointer.next = new ListNode(1);
        }
        return head;
    }
}
