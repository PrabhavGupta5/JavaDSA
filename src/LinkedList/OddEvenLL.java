package LinkedList;

// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLL {
    // Using dummy nodes
    public ListNode oddEvenList(ListNode head) {
        // have to return a linkedlist basically modify the pointers such that
        ListNode oddHead = new ListNode(-1); // start of your list
        ListNode evenHead = new ListNode(-1); // start of your list having even index

        ListNode odd = oddHead; // moving pointers
        ListNode even = evenHead;

        while(head != null && head.next != null) {
            // if index is odd
            odd.next = head;
            odd = odd.next;
            // if index is even
            even.next = head.next;
            even = even.next;

            head = head.next.next;
        }

        // handle last odd node (if list length is odd)
        if (head != null) {
            odd.next = head;
            odd = odd.next;
        }
        even.next = null;
        odd.next = evenHead.next;  // connect two nodes

        return oddHead.next;

    }

    // InPlace Modification
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
