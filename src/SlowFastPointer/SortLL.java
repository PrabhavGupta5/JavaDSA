package SlowFastPointer;

public class SortLL {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){ // we are dividing the list into two parts slow will be the head of the second half
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow);

        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
