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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode outputHead = new ListNode();
        ListNode outputList = outputHead;
        
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            int l1num = 0;
            int l2num = 0;
            
            if (l1 != null)
                l1num = l1.val;
            else
                l1num = 0;
            if (l2 != null)
                l2num = l2.val;
            else
                l2num = 0;
            
            int outputNum = l1num + l2num + carry;
            
            carry = outputNum / 10;
            
            outputList.next = new ListNode(outputNum % 10);
            
            outputList = outputList.next;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry != 0)
        {
            outputList.next = new ListNode(1);
            outputList = outputList.next;
        }
        
        return outputHead.next;
        
        
    }
}