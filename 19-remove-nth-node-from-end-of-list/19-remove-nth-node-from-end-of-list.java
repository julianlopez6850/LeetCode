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
class Solution {
    
    ListNode dummyhead = new ListNode();
    Boolean end = false;
    int counter = -1;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        dummyhead.next = head;
        removeNthHelper(dummyhead, n);
        return dummyhead.next;
    }
    
    public ListNode removeNthHelper(ListNode head, int n)
    {
        if(head.next != null)
        {
            removeNthHelper(head.next, n);
        }
        else
            end = true;
        if(end == true)
            counter++;
        if(counter == n)
        {
            if(head.next != null)
            {
                head.next = head.next.next;
            }
            else
            {
                head = null;
            }
        }
        return head;
    }
}