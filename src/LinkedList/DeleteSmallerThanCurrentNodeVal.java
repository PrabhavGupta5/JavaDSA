package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/remove-nodes-from-linked-list/description/
// We have reversed the linked list than looking for maximum value seen so far, if the next is smaller than the current one, skip that node
public class DeleteSmallerThanCurrentNodeVal {

    // In this question we have to remove the nodes which are smaller than the current node, so we will reverse the linked list and then check for the maximum value seen so far, if the next node is smaller than the current node, we will skip that node
    public static ListNode removeNodes(ListNode head) {
        head = reverse(head);
        // we will check for the maximum so far
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.next.val < curr.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return reverse(head);
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Queue<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(2);
        ll.add(13);
        ll.add(3);
        ll.add(8);
        removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8))))));

    }
}
// why need to reverse the linked list ?
// we have to remove the nodes which are smaller than the current node, so we will reverse the linked list and then check for the maximum value seen so far, if the next node is smaller than the current node, we will skip that node
// for example :
// 12 -> 15 -> 10 -> 11 -> 5 -> 6 -> 2 -> 3
// after reversing : 3 -> 2 -> 6 -> 5 -> 11 -> 10 -> 15 -> 12
// we will check for the maximum value seen so far

// Dry run this.