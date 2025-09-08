package SlowFastPointer;


// https://leetcode.com/problems/add-two-numbers/

// https://www.youtube.com/watch?v=XmRrGzR6udg
public class AddtwoLL {

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
        ListNode cur = dummy;
        ListNode t1 = l1, t2 = l2;

        int carry = 0;

        while(t1 != null || t2 != null || carry != 0) {
            int sum = 0;
            if(t1 != null) {
                sum = sum + t1.val;
                t1 = t1.next;
            }
            if(t2 != null) {
                sum = sum + t2.val;
                t2 = t2.next;
            }
            sum = sum + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = newNode;
            cur = cur.next;

        }

        return dummy.next;

    }
}