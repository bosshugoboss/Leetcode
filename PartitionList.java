public class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode before = null;
        ListNode beforeHead = null;
        ListNode after = null;
        ListNode afterHead = null;
        if(head == null) return null;
        while(head != null){
             if(head.val < x) {    
                 if(before != null) {
                  before.next = head;
             	} 
             	if(before == null) beforeHead = head;
             	before = before == null ? head : before.next;
             }
             else{
             	if(after != null) {
             	   after.next = head;
             	}
             	if(after == null) afterHead = head;
             	after = after == null? head: after.next;
             }
             head = head.next;
        }
        if(after != null) after.next = null;
        if(beforeHead != null){
          before.next = afterHead;
          return beforeHead;
        }
        else return afterHead;
    }   
}
