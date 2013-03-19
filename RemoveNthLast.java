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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        ListNode bottom = head;
        ListNode father = head;
        for(int index = 1 ; index < n; index ++){            
            bottom = bottom.next;
        }
        while(bottom.next != null){
            bottom = bottom.next;
            father = current;
            current = current.next;
        }
        if(current != null && current.next != null){
         int value = current.next.val;    
         current.next = current.next.next;
         current.val = value;
        }
        else if(current != null && current.next == null){
          if(current != head)
           father.next = null;
          else
           head = null;
        }
        
        return head;
    }  
}
