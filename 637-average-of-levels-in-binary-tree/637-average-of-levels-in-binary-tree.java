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
    List<Double> result = new ArrayList<Double>();
    
    int levelCounter = 0;
    long levelSum = 0;
    int nodeCounter = 0;
    
    public List<Double> averageOfLevels(TreeNode root) {
        
        queue.add(null);
        levelOrderTraversal(root);
        return result;
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root)
    {
        if(root != null)
        {
            list.add(root.val);
            if(root.left != null)
                queue.add(root.left);
            if(root.right != null)
                queue.add(root.right);
            levelSum += root.val;
            nodeCounter++;
        }
        else if(queue.size() > 0)
        {
            list.add(null);
            queue.add(null);
            result.add(levelCounter, levelSum / Double.valueOf(nodeCounter));
            nodeCounter = 0;
            levelSum = 0;
            levelCounter++;
        }
        if(queue.size() > 0)
            levelOrderTraversal(queue.remove());
        else
            result.add(levelCounter, levelSum / Double.valueOf(nodeCounter));
        return list;
    }
}