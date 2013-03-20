public class Solution {
  public static ListNode reverseKGroup(ListNode head, int k) {       
        ListNode firstPointer = head;
        ListNode lastPointer = head;
        ListNode newHead = head;
        ListNode tempHead = head;
        while(firstPointer != null){
           for(int index = 1; index < k; index ++){
              lastPointer = lastPointer.next;
              if(lastPointer == null) return newHead;
           }           
        if(firstPointer == head) newHead = lastPointer;
        else tempHead.next = lastPointer;
           ListNode current = firstPointer;
           ListNode prev = lastPointer.next;
           ListNode nextPointer = prev;
           while(current != nextPointer){              
              ListNode next = current.next;
              current.next = prev;
              prev = current;
              current = next;                
           }
           tempHead = firstPointer;
           firstPointer = nextPointer;          
           lastPointer = firstPointer;
        }
        return newHead;
    }
}
