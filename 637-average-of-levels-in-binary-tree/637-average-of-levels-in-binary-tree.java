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
    
    public List<Double> averageOfLevels(TreeNode root) {
        
        queue.add(null);
        levelOrderTraversal(root, 0, 0, 0);
        return result;
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root, int levelCounter, long levelSum, int nodeCounter)
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
            levelOrderTraversal(queue.remove(), levelCounter, levelSum, nodeCounter);
        else
            result.add(levelCounter, levelSum / Double.valueOf(nodeCounter));
        return list;
    }
}