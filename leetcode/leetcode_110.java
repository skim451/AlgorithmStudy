/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int dfsHeight(TreeNode root) {
        if(root == null) 
            return 0; 
        
        int leftHeight = dfsHeight(root.left); 
        if (leftHeight == -1) return -1; 
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;
        
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1; 
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1; 
    }
    
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) > -1; 
    }
}