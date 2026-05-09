package LinkedList;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// The approach is to use two pointers, one pointer is n steps ahead of the other pointer, then we move both pointers one step at a time until the second pointer reaches the end of the list, at that point the first pointer will be at the node just before the node we want to remove, then we can simply change the next pointer of the first pointer to skip the node we want to remove.
// Time Complexity: O(n) where n is the number of nodes in the linked list
// Space Complexity: O(1) we are not using any extra space
public class RemoveNthNodefromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        // iterate n times the second ptr
        for(int i = 0; i < n; i++) {
            secondPtr = secondPtr.next;
        }

        // go to the last
        while(secondPtr.next != null) {
            secondPtr = secondPtr.next;
            firstPtr = firstPtr.next;
        }

        firstPtr.next = firstPtr.next.next;
        return dummy.next;
    }



    // One more way is by reversing Brute way
    public ListNode removeNthFromEndII(ListNode head, int n) {
        // Step 1: reverse the list
        head = reverse(head);
        // Step 2: remove nth node from start
        if (n == 1) {
            head = head.next;
        } else {
            ListNode curr = head;
            for (int i = 1; i < n - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        // Step 3: reverse again to restore order
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }
}
