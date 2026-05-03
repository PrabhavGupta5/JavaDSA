package LinkedList;

// https://leetcode.com/problems/remove-linked-list-elements/description/
public class RemoveValNodesInLL {
    // Using Recursion, simply move ahead then check if the value is same then head = head.next;
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // process rest of the list first
        head.next = removeElements(head.next, val);

        // now decide for current node
        if (head.val == val)
            return head.next; // delete current

        return head; // keep current
    }

    // iterative solution:
    public ListNode removeElementsII(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while(curr.next != null) {
            if(curr.next.val == val) {
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return dummy.next;
    }

    // Input: head = [1,2,6,3,4,5,6], val = 6
    // Output: [1,2,3,4,5]

}
