public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode firstPointer = head;
        ListNode lastPointer = head;
        ListNode newHead = head;
        while(firstPointer != null){
           for(int index = 1; index < k; index ++){
              if(lastPointer == null) return newHead;
              lastPointer = lastPointer.next;
           }
           if(firstPointer == head) newHead = lastPointer;
           ListNode current = firstPointer;
           ListNode prev = lastPointer.next;
           while(current != lastPointer.next){
              ListNode next = current.next;
              current.next = prev;
              prev = current;
              current = next;              
           }
           firstPointer = lastPointer.next;
        }
        return newHead;
    }
}
