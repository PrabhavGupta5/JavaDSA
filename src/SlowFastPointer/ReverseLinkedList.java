package SlowFastPointer;

// https://leetcode.com/problems/reverse-linked-list/

// Watch this video for reference: https://www.youtube.com/watch?v=D2vI2DNJGd8
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;

    }
}