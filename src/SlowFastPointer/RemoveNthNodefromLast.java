package SlowFastPointer;

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
