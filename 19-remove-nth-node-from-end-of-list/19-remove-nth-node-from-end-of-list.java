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
    
    int counter = 0;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(0, head);
        removeNthHelper(dummyhead, n);
        return dummyhead.next;
    }
    
    public ListNode removeNthHelper(ListNode head, int n)
    {
        if(head.next != null)
            removeNthHelper(head.next, n);
        if(counter++ == n)
            head.next = head.next.next;
        return head;
    }
}