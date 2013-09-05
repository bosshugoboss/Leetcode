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

/*new */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0) return head;
        int length = 0;
        ListNode current = head;
        ListNode tail = head;
        while(current != null){
            length ++;
            if(current.next == null) tail = current;
            current = current.next;
        }
        int rotate = n % length;
        if(rotate == 0) return head;
        current = head;
        int rest = length - rotate;
        while(rest > 1){
            current = current.next;
            rest --;
        }
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;
        return newHead;
    }
}
