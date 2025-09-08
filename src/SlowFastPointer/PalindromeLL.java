package SlowFastPointer;


// https://leetcode.com/problems/palindrome-linked-list/

// For reference : https://www.youtube.com/watch?v=lRY_G-u_8jk
public class PalindromeLL {
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
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         Stack<Integer> stack = new Stack<>();
//         ListNode curr = head;

//         while(curr != null){
//             stack.push(curr.val);
//             curr = curr.next;
//         }

//         curr = head;
//         while(curr != null){
//             if(stack.pop() != curr.val)
//                 return false;
//             curr = curr.next;
//         }

//         return true;
//     }
// }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }

        reverse(slow);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}