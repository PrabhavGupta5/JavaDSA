package LinkedList;

// https://leetcode.com/problems/rotate-list/

// https://www.youtube.com/watch?v=uT7YI7XbTY8
// In this question I am forming a circular linked list first then do what the question says
public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;

        // have to find the tail to connect to head
        while(tail.next != null) {
            len+=1;
            tail = tail.next;
        }
        tail.next = head;

        if( k % len == 0)
            return head;

        k = k % len; // Used to shorten the k

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

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]