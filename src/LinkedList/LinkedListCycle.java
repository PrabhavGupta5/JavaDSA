package LinkedList;


// https://leetcode.com/problems/linked-list-cycle-ii/description/
public class LinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if they are equal then we have a cycle, and we have to find the starting point of the cycle, move slow to head and keep fast at the meeting point, move both one step at a time, the point at which they meet is the starting point of the cycle
            if(fast == slow)   {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    // Basic Cycle detection
    // https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = head.next;
            fast = head.next.next;

            if(fast == slow)
                return true;
        }

        return false;
    }


    // Duplicate number also
    // https://leetcode.com/problems/find-the-duplicate-number/description/
    // https://www.youtube.com/watch?v=_n5MR8IxR6c
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
