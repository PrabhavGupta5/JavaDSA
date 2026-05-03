package LinkedList;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// https://www.youtube.com/watch?v=lIar1skcQYI&t=1112s Must watch for this hard problem
public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummy = new ListNode(); // dummy node to return ans
        ListNode ans = dummy;

        int count = 0;
        ListNode currHead = head;

        while (temp!= null){

            count++; // increase the counter till we have k elements

            if(count == k){
                ListNode nextNode = temp.next; // store the next node
                temp.next = null; //break the ll to form a chunk of size k

                ListNode reversedLL = reverse(currHead); //reverse the chunk
                ans.next = reversedLL; // connect the chunk to ans

                ListNode tailNode = currHead; // previous head of the chunk will now become the tail after reversal
                tailNode.next = nextNode; // connect tail to next node saved earlier

                ans = tailNode; //move ans to the tail
                temp = nextNode; // move temp to the next node where we can start counting k chunk

                currHead = temp; // current head of the chunk will be where temp starts
                count=0; // reset the counter

            }else
                temp = temp.next; // if we do not have k elements in the chunk , keep moving temp;
        }
        return dummy.next; // where ans begins
    }


    public ListNode reverse(ListNode head){ // helper function to reverse ll
        ListNode current = head;
        ListNode prev = null;
        while(current !=null) {
            ListNode newNode = current.next;
            current.next = prev;
            prev = current;
            current = newNode;
        }
        head = prev;
        return head;
    }
}
