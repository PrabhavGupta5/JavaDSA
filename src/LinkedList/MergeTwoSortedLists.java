package LinkedList;


// https://leetcode.com/problems/merge-two-sorted-lists/

// https://www.youtube.com/watch?v=jXu-H7XuClE
public class MergeTwoSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }

        if (list1 == null) curr.next = list2;
        else curr.next = list1;

        return dummy.next;

    }



    // Merge K sorted Lists
    // https://leetcode.com/problems/merge-k-sorted-lists/description/
    // hard question, we can use divide and conquer approach, we can merge two lists at a time, and then merge the merged list with the next list, and so on, until we have merged all the lists, this will take O(n log k) time complexity, where n is the total number of nodes in all the lists and k is the number of lists
    // https://www.youtube.com/watch?v=3H9izDal-pA&list=PLFdAYMIVJQHN6J5-OCh7pbG0o8WHC9so3&index=29
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

}