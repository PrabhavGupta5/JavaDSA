package LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        // first we need to find the middle node
        // reverse after the middle
        // merge the first half and the reverse part
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null; // to break the link between first and second
        ListNode first = head;
        // we need to merge them now :

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


//1 → 2 → 3 → 4 → 5
//First:  1 → 2 → 3
//Second: 4 → 5
//Reverse: 5 → 4
//Merge:
//        1 → 5 → 2 → 4 → 3