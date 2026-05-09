package LinkedList;


// https://leetcode.com/problems/add-two-numbers/
// https://www.youtube.com/watch?v=KMS0WFxrsT8
public class AddTwoLL {

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;  // pointer node

    int carry = 0;

    while(l1 != null || l2 != null) {
        int sum = 0 + carry;
        if(l1 != null) {
            sum = sum + l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            sum = sum + l2.val;
            l2 = l2.next;
        }
        carry = sum / 10;
        sum = sum % 10;
        cur.next = new ListNode(sum);
        cur = cur.next;
    }
    if(carry == 1)
        cur.next = new ListNode(1);

    return dummy.next;

}
}