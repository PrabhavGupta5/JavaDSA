package SlowFastPointer;

// https://leetcode.com/problems/rotate-list/

// https://www.youtube.com/watch?v=uT7YI7XbTY8
public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;

        while(tail.next != null) {
            len+=1;
            tail = tail.next;
        }

        if( k % len == 0)
            return head;

        k = k % len;

        tail.next = head;

        // Find new tail (len - k - 1 steps from head)
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null;

        return head;

    }
}