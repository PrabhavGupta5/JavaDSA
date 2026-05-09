package LinkedList;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
// example: 1->2->3->4->5, middle is 3, so we have to delete 3 and connect 2 to 4
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;

    }
}
