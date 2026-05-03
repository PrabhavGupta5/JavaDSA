package LinkedList;

// https://leetcode.com/problems/remove-nodes-from-linked-list/description/
// We have reversed the linked list than looking for maximum value seen so far, if the next is smaller than the current one, skip that node
public class DeleteSmallerThanCurrentNodeVal {

    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        // we will check for the maximum so far
        int max = Integer.MIN_VALUE;
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.next.val < curr.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
