package SlowFastPointer;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null){
            if(fast.next == null)
                return slow;

            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }
}

