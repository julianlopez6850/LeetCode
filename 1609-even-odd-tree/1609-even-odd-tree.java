/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<Integer> list = new ArrayList<Integer>();
    
    public boolean isEvenOddTree(TreeNode root) {
        
        queue.add(null);
        levelOrderTraversal(root);
        
        int prevValue = 0;
        int currValue = 0;
        
        boolean evenLevel = true;
        boolean firstValueInLevel = false;
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) == null)
            {
                evenLevel = !evenLevel;
                firstValueInLevel = true;
            }
            if(list.get(i) != null)
            {
                currValue = list.get(i);
            
                if((evenLevel && currValue % 2 == 0) || (!evenLevel && currValue % 2 == 1))
                    return false;
                else if(firstValueInLevel)
                {
                    prevValue = currValue;
                    firstValueInLevel = false;
                }
                else if(evenLevel)
                {
                    if(currValue <= prevValue)
                        return false;
                    else
                        prevValue = currValue;
                }
                else if(!evenLevel)
                {
                    if(currValue >= prevValue)
                        return false;
                    else
                        prevValue = currValue;
                }
            }
        }
        return true;
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root) {
        if(root != null)
        {
            list.add(root.val);
            if(root.left != null)
                queue.add(root.left);
            if(root.right != null)
                queue.add(root.right);
        }
        else if(queue.size() > 0)
        {
            list.add(null);
            queue.add(null);
        }
        if(queue.size() > 0)
            levelOrderTraversal(queue.remove());
        return list;
    }
}