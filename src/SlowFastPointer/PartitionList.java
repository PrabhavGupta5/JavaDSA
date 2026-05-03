package SlowFastPointer;

// https://leetcode.com/problems/partition-list/
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
// move values less than x to the front, keep the order intact
//     [1, 2, 2] → all < 3 (same order as original)
//     [4, 3, 5] → all ≥ 3 (same order)
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // have to return a linkedlist basically modify the pointers such that
        ListNode lessHead = new ListNode(-1); // start of your list
        ListNode greaterHead = new ListNode(-1); // start of your list having values greater than x

        ListNode less = lessHead; // moving pointers
        ListNode greater = greaterHead;

        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = less.next;
            }
            else  {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;

    }
}
