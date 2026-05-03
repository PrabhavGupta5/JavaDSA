package LinkedList;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/
// Input: head = [1,2,3,4]
//
// Output: [2,1,4,3]
public class SwapNodesinLL {
    // Iterative approach, think it big
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }

    // Recursive approach
    public ListNode swapPairs2(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        // recurse for remaining list
        first.next = swapPairs2(second.next);

        // swap
        second.next = first;

        return second;
    }
}
