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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummyHead = new ListNode();
        ListNode mergedList = dummyHead;
        
        ListNode currNode = new ListNode();
        ListNode lowestNode = new ListNode();
        
        int listIndex = 0;
        
        while(lists.length > 0)
        {
            listIndex = 0;
            lowestNode = lists[0];
            for(int i = 0; i < lists.length; i++)
            {
                if(lists[i] != null)
                {
                    currNode = lists[i];
                    if(lowestNode == null)
                    {
                        listIndex = i;
                        lowestNode = currNode;
                    }
                    if(currNode.val < lowestNode.val)
                    {
                        listIndex = i;
                        lowestNode = currNode;
                    }
                }
            }
            if(lowestNode == null)
                break;
            mergedList.next = lowestNode;
            mergedList = mergedList.next;
            lists[listIndex] = lists[listIndex].next;
        }
        
        return dummyHead.next;
    }
}