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
        
        int listIndex = 0;
        while(lists.length > 0)
        {
            listIndex = 0;
            mergedList.next = lists[0];
            for(int i = 0; i < lists.length; i++)
                if(lists[i] != null)
                    if(mergedList.next == null || lists[i].val < mergedList.next.val)
                    {
                        listIndex = i;
                        mergedList.next = lists[i];
                    }
            if(mergedList.next == null)
                return dummyHead.next;
            mergedList = mergedList.next;
            lists[listIndex] = lists[listIndex].next;
        }
        return dummyHead.next;
    }
}