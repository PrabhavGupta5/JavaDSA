package SlowFastPointer;

public class RemoveDuplicatesFromLLVariations {
    // Simple delete duplicates in sorted LL, keep one element of duplicate
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }

    // Now remove the duplicates all together from the list
    // https://www.youtube.com/watch?v=eFPFwwojxGU&list=PLFdAYMIVJQHN6J5-OCh7pbG0o8WHC9so3&index=29

    public ListNode deleteDuplicatesAll(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // detect duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // skip ALL duplicates
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // delete entire block
                prev.next = curr.next; // shift prev to delete entire block of duplicate values

            } else
                prev = prev.next; // move prev only if no duplicate

            curr = curr.next;
        }
        return dummy.next;
    }


}
