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

        // In this we are moving straight forward because the digits are stored in reverse order, so we can just add the digits and move to the next node, and if there is a carry, we will add it to the next sum
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
            carry = sum / 10; // if sum is 15, then carry will be 1, if sum is 9, then carry will be 0
            sum = sum % 10; // if sum is 15, then sum will be 5, if sum is 9, then sum will be 9
            cur.next = new ListNode(sum); // create a new node with the sum and connect it to the current node
            cur = cur.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);

        return dummy.next;

    }
    // example : l1 = 2 -> 4 -> 3, l2 = 5 -> 6 -> 4
    // output : 7 -> 0 -> 8
    // output will be 7 -> 0 -> 8 because 342 + 465 = 807, and we are storing the digits in reverse order, so the output will be 7 -> 0 -> 8
   }