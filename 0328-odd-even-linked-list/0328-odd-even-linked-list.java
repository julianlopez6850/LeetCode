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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode odds = head;
        ListNode evens = head.next;
        ListNode evensHead = evens;
        
        while(evens != null && evens.next != null) {
            odds.next = odds.next.next;
            odds = odds.next;
            evens.next = evens.next.next;
            evens = evens.next;
        }
        odds.next = evensHead;
        return head;
    }
}