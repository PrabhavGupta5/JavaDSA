package SlowFastPointer;

public class ReverseLL2 {
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
// https://leetcode.com/problems/reverse-linked-list-ii/

// https://www.youtube.com/watch?v=oDL8vuu2Q0E&t=915s
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        for(int i = 0; i < left-1; i++){
            pre = pre.next;
            cur = cur.next;
        }

        ListNode sublistHead = cur;
        ListNode preNode = null;

        for(int i = 0; i <= right-left; i++) {
            ListNode nextNode = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = nextNode;
        }

        pre.next = preNode;
        sublistHead.next = cur;

        return dummy.next;
    }
}