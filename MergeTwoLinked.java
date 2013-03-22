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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode newHead = l1.val <= l2.val? new ListNode(l1.val) : new ListNode(l2.val);
        ListNode newPointer = newHead;
        ListNode pointerOne = l1.val <= l2.val? l1.next : l1;
        ListNode pointerTwo = l1.val <= l2.val? l2 : l2.next;
        while(pointerOne != null && pointerTwo != null){
            if(pointerOne.val <= pointerTwo.val){  
               newPointer.next = new ListNode(pointerOne.val);
               pointerOne = pointerOne.next;
            }
            else{
               newPointer.next = new ListNode(pointerTwo.val);
               pointerTwo = pointerTwo.next;
            }
            newPointer = newPointer.next;
        }
        if(pointerOne == null) newPointer.next = pointerTwo;
        if(pointerTwo == null) newPointer.next = pointerOne;
        return newHead;
    }
}
